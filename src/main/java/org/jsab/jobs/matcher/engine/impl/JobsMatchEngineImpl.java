package org.jsab.jobs.matcher.engine.impl;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jsab.jobs.matcher.engine.JobsMatchEngine;
import org.jsab.jobs.matcher.engine.WorkerJobMatchCondition;
import org.jsab.jobs.matcher.exceptions.MatcherArgumentException;
import org.jsab.jobs.matcher.exceptions.MatcherApplicationException;
import org.jsab.jobs.matcher.model.Job;
import org.jsab.jobs.matcher.model.Worker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.jsab.jobs.matcher.dataapi.DataAPIConnector;

/**
 * Jobs Match Engine default implementation
 * 
 * @author JorgeLuis
 */
@Service
public class JobsMatchEngineImpl implements JobsMatchEngine
{
  private static final Logger LOGGER = LoggerFactory.getLogger(JobsMatchEngineImpl.class);
  
  private static final WorkerJobMatchCondition[] MATCH_CONDITIONS = {
    new DriversLicenceMatchCondition(), new CertificatesMatchCondition(), new LocationMatchCondition()
  };

  private static final int MAX_AVAILABLE_JOBS_FOR_WORKER = 3;
  
  @Autowired
  private DataAPIConnector sjAPIConnector;
  
  void setDataAPIConnector(DataAPIConnector newAPIConnector)
  {
    if (sjAPIConnector == null && newAPIConnector != null) {
      sjAPIConnector = newAPIConnector;
    }
  }
  
  @Cacheable(value = "jobsPerWorker")
  @Override
  public List<Job> findSuitableJobs(long workerId) throws MatcherApplicationException
  {
    if (workerId < 0) {
      throw new MatcherArgumentException("Invalid worker id");
    }

    // Looks up the worker ID
    Map<Long, Worker> myWorkers = sjAPIConnector.retrieveWorkers();
    
    Worker myWorker = myWorkers.get(workerId);
    if (null == myWorker) {
      throw new MatcherArgumentException("Worker information not available: " + workerId);
    }
    
    return findSuitableJobs(myWorker);
  }

  private List<Job> findSuitableJobs(Worker worker) throws MatcherApplicationException
  {
    if (!worker.getIsActive()) {
      // not jobs for worker
      return Collections.EMPTY_LIST;
    }
    
    // Gets for available jobs
    List<Job> myAvailableJobs = sjAPIConnector.retrieveJobs();
    
    BillRateComparator myBillRateComparator = new BillRateComparator();
    // Checks for appropriate jobs
    myAvailableJobs = myAvailableJobs.stream()
                                     .filter(job -> isMatch(worker, job))
                                     .sorted(myBillRateComparator)
                                     .limit(MAX_AVAILABLE_JOBS_FOR_WORKER)
                                     .collect(Collectors.toList()); // Returns an ArrayList instance.

    LOGGER.info("{} jobs found for worker ID {}", myAvailableJobs.size(), worker.getUserId());
    
    return myAvailableJobs;
  }
  
  private boolean isMatch(Worker worker, Job job)
  {
    for (WorkerJobMatchCondition myCondition : MATCH_CONDITIONS) {
      if (!myCondition.isMatch(worker, job)) {
        return false;
      }
    }
    
    return true;
  }

  private static class BillRateComparator implements Comparator<Job>
  {
    @Override
    public int compare(Job job1, Job job2)
    {
      double myBillRate1 = 0.0;
      double myBillRate2 = 0.0;
      
      try {
        NumberFormat myFormatter = NumberFormat.getCurrencyInstance();
        myBillRate1 = myFormatter.parse(job1.getBillRate()).doubleValue();
        myBillRate2 = myFormatter.parse(job2.getBillRate()).doubleValue();
      }
      catch (ParseException e) {
        LOGGER.warn("Format invalid for Job bill rate", e);
      }
      
      return Double.compare(myBillRate2, myBillRate1); // reverse order
    }
  }
}