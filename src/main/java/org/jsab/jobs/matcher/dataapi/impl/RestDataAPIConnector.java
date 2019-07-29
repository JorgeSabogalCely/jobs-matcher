package org.jsab.jobs.matcher.dataapi.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jsab.jobs.matcher.dataapi.DataAPIConnector;
import org.jsab.jobs.matcher.exceptions.MatcherApplicationException;
import org.jsab.jobs.matcher.model.Job;
import org.jsab.jobs.matcher.model.Worker;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Implementation of API connector as as Spring RESTful client consuming existing 'jobs' API services. It uses
 * two caches 'workers' and 'jobs'.
 * 
 * @author JorgeLuis
 */
@Service
public class RestDataAPIConnector implements DataAPIConnector
{
  private static final String WORKERS_RS_ENDPOINT = "http://test.jobs.jsab.org/api/workers";
  private static final String JOBS_RS_ENDPOINT = "http://test.jobs.jsab.org/api/jobs";

  @Cacheable(value = "workers")
  @Override
  public Map<Long, Worker> retrieveWorkers() throws MatcherApplicationException
  {
    List<Worker> myWorkers = null;
	
    RestTemplate myRestTemplate = new RestTemplate();
	
    try {
      myWorkers = myRestTemplate.exchange(WORKERS_RS_ENDPOINT, HttpMethod.GET, null,
                                          new ParameterizedTypeReference<List<Worker>>(){}).getBody();
    }
    catch(HttpClientErrorException e) {
      throw new MatcherApplicationException("Workers service not available", e);
    }
    
    if (null == myWorkers || myWorkers.isEmpty()) {
      throw new MatcherApplicationException("Worker information not available");
    }

    return myWorkers.stream().collect(Collectors.toMap(Worker::getUserId, worker -> worker));
  }

  @Cacheable(value = "jobs")
  @Override
  public List<Job> retrieveJobs() throws MatcherApplicationException
  {
    List<Job> myJobs = null;

    RestTemplate myRestTemplate = new RestTemplate();
    
    try {
      myJobs = myRestTemplate.exchange(JOBS_RS_ENDPOINT, HttpMethod.GET, null,
                                       new ParameterizedTypeReference<List<Job>>(){}).getBody();
    }
    catch(HttpClientErrorException e) {
      throw new MatcherApplicationException("Jobs service not available", e);
    }
    
    if (null == myJobs || myJobs.isEmpty()) {
      throw new MatcherApplicationException("Jobs information not available");
    }
      
    return myJobs;
  }
}