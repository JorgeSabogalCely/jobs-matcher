package org.jsab.jobs.matcher.engine.impl;

import org.jsab.jobs.matcher.engine.WorkerJobMatchCondition;
import org.jsab.jobs.matcher.model.DistanceUnit;
import org.jsab.jobs.matcher.model.Job;
import org.jsab.jobs.matcher.model.Worker;

/**
 *
 * @author JorgeLuis
 */
public class LocationMatchCondition implements WorkerJobMatchCondition
{
  @Override
  public boolean isMatch(Worker worker, Job job)
  {
    // Worker location coordinates
    double myWorkerLatitude = worker.getJobSearchAddress().getLatitude().doubleValue();
    double myWorkerLongitude = worker.getJobSearchAddress().getLongitude().doubleValue();
    
    // Job location coordinates
    double myJobLatitude = job.getLocation().getLatitude().doubleValue();
    double myJobLongitude = job.getLocation().getLongitude().doubleValue();
    
    double myDistance = calculateDistance(myWorkerLatitude, myWorkerLongitude, myJobLatitude, myJobLongitude,
                                          worker.getJobSearchAddress().getUnit());
    
    return myDistance <= worker.getJobSearchAddress().getMaxJobDistance();
  }

  private double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2,
                                   DistanceUnit unit)
  {
    if ((latitude1 == latitude2) && (longitude1 == longitude2)) {
      return 0;
    }
    
    double myTheta = longitude1 - longitude2;
    double myDistancia = Math.sin(Math.toRadians(latitude1)) * Math.sin(Math.toRadians(latitude2))
                         + Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
                         * Math.cos(Math.toRadians(myTheta));
    myDistancia = Math.acos(myDistancia);
    myDistancia = Math.toDegrees(myDistancia);
    myDistancia *= (60 * 1.1515);
    if (unit == DistanceUnit.KM) {
      myDistancia *= 1.609344;
    }
    else if (unit == DistanceUnit.NAUTICAL_MILES) {
      myDistancia *= 0.8684;
    }
    
    return myDistancia;
  }
}