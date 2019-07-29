package org.jsab.jobs.matcher.engine.impl;

import org.jsab.jobs.matcher.engine.WorkerJobMatchCondition;
import org.jsab.jobs.matcher.model.Job;
import org.jsab.jobs.matcher.model.Worker;
import org.jsab.jobs.matcher.model.WorkerTransportation;

/**
 *
 * @author JorgeLuis
 */
public class DriversLicenceMatchCondition implements WorkerJobMatchCondition
{
  @Override
  public boolean isMatch(Worker worker, Job job)
  {
    return (job.isDriverLicenseRequired() && worker.isHasDriversLicense()
            && worker.getTransportation() == WorkerTransportation.CAR)
            || !job.isDriverLicenseRequired();
  }  
}
