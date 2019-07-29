package org.jsab.jobs.matcher.engine;

import java.math.BigDecimal;
import org.jsab.jobs.matcher.engine.impl.LocationMatchCondition;
import org.jsab.jobs.matcher.model.DistanceUnit;
import org.jsab.jobs.matcher.model.Job;
import org.jsab.jobs.matcher.model.JobLocation;
import org.jsab.jobs.matcher.model.JobSearchAddress;
import org.jsab.jobs.matcher.model.Worker;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author JorgeLuis
 */
public class LocationMatchConditionTest
{
  
  public LocationMatchConditionTest()
  {
  }
  
  @BeforeClass
  public static void setUpClass()
  {
  }
  
  @AfterClass
  public static void tearDownClass()
  {
  }
  
  @Before
  public void setUp()
  {
  }
  
  @After
  public void tearDown()
  {
  }

  /**
   * Test of isMatch method, of class LocationMatchCondition.
   */
  @Test
  public void testIsMatch()
  {
    System.out.println("testIsMatch");

    JobLocation myLocation = new JobLocation();
    myLocation.setLatitude(new BigDecimal("13.864602"));
    myLocation.setLongitude(new BigDecimal("49.93359"));
    Job myJob = new Job();
    myJob.setLocation(myLocation);
    
    JobSearchAddress mySearchAddress = new JobSearchAddress();
    mySearchAddress.setMaxJobDistance(30);
    mySearchAddress.setUnit(DistanceUnit.KM);
    mySearchAddress.setLatitude(new BigDecimal("13.971284"));
    mySearchAddress.setLongitude(new BigDecimal("49.782281"));
    Worker myWorker = new Worker();
    myWorker.setJobSearchAddress(mySearchAddress);
   
    // Expected distance between these two points is 20km.
    
    LocationMatchCondition myCondition = new LocationMatchCondition();
    assertTrue(myCondition.isMatch(myWorker, myJob));

    mySearchAddress.setMaxJobDistance(19);
    assertFalse(myCondition.isMatch(myWorker, myJob));
  } 
}