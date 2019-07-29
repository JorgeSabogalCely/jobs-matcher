package org.jsab.jobs.matcher.engine.impl;

import org.jsab.jobs.matcher.engine.impl.JobsMatchEngineImpl;
import java.util.List;
import org.jsab.jobs.matcher.engine.MockAPIConnector;
import org.jsab.jobs.matcher.exceptions.MatcherApplicationException;
import org.jsab.jobs.matcher.model.Job;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author JorgeLuis
 */
public class JobsMatchEngineTest
{
  private JobsMatchEngineImpl matchEngine;

  @Before
  public void setUp()
  {
    matchEngine = new JobsMatchEngineImpl();
    matchEngine.setDataAPIConnector(new MockAPIConnector());
  }

  @After
  public void tearDown()
  {
  }

  /**
   * Test of findSuitableJobs method, of class JobsMatchEngine.
   * @throws org.jsab.jobs.matcher.exceptions.MatcherApplicationException
   */
  @Test
  public void testFindSuitableJobs() throws MatcherApplicationException
  {
    System.out.println("testFindSuitableJobs");
    
    List<Job> myJobs = matchEngine.findSuitableJobs(0);
    assertEquals(2, myJobs.size());
    assertEquals(26, myJobs.get(0).getJobId());
    assertEquals(35, myJobs.get(1).getJobId());

    myJobs = matchEngine.findSuitableJobs(1);
    assertEquals(0, myJobs.size());

    myJobs = matchEngine.findSuitableJobs(12);
    assertEquals(3, myJobs.size());
    assertEquals(13, myJobs.get(0).getJobId());
    assertEquals(9, myJobs.get(1).getJobId());
    assertEquals(12, myJobs.get(2).getJobId());
  }  
}