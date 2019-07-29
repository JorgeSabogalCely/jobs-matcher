package org.jsab.jobs.matcher.engine;

import java.util.List;
import org.jsab.jobs.matcher.exceptions.MatcherApplicationException;
import org.jsab.jobs.matcher.model.Job;
import org.springframework.stereotype.Service;

/**
 * Jobs Match Engine
 * 
 * @author JorgeLuis
 */
@Service
public interface JobsMatchEngine
{
  List<Job> findSuitableJobs(long workerId) throws MatcherApplicationException;
}