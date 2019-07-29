package org.jsab.jobs.matcher.engine;

import org.jsab.jobs.matcher.model.Job;
import org.jsab.jobs.matcher.model.Worker;

/**
 *
 * @author JorgeLuis
 */
public interface WorkerJobMatchCondition
{
  boolean isMatch(Worker worker, Job job);
}