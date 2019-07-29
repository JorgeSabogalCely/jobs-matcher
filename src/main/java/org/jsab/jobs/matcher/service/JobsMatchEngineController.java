package org.jsab.jobs.matcher.service;

import java.util.List;
import org.jsab.jobs.matcher.engine.JobsMatchEngine;
import org.jsab.jobs.matcher.exceptions.MatcherApplicationException;
import org.jsab.jobs.matcher.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JorgeLuis
 */
@RestController
@RequestMapping("/match")
public class JobsMatchEngineController
{
  @Autowired
  private JobsMatchEngine matchEngine;
  
  @RequestMapping(value="/jobs/{wId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_STREAM_JSON_VALUE)
  public List<Job> findJobs(@PathVariable("wId") long workerId) throws MatcherApplicationException
  {
    return matchEngine.findSuitableJobs(workerId);
  }
}