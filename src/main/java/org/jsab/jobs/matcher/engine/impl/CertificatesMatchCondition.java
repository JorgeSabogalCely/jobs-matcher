package org.jsab.jobs.matcher.engine.impl;

import org.jsab.jobs.matcher.engine.WorkerJobMatchCondition;
import org.jsab.jobs.matcher.model.Job;
import org.jsab.jobs.matcher.model.Worker;

/**
 * @author JorgeLuis
 */
public class CertificatesMatchCondition implements WorkerJobMatchCondition
{
  @Override
  public boolean isMatch(Worker worker, Job job)
  {
    return worker.getCertificates().containsAll(job.getRequiredCertificates());
  }
}