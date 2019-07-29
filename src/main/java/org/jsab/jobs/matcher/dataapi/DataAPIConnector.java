package org.jsab.jobs.matcher.dataapi;

import java.util.List;
import java.util.Map;
import org.jsab.jobs.matcher.exceptions.MatcherApplicationException;
import org.jsab.jobs.matcher.model.Job;
import org.jsab.jobs.matcher.model.Worker;

/**
 * API connector to required data-related 'jobs' API for available workers and Jobs.
 */
public interface DataAPIConnector
{
  Map<Long, Worker> retrieveWorkers() throws MatcherApplicationException;
  List<Job> retrieveJobs() throws MatcherApplicationException;
}