package org.jsab.jobs.matcher.engine;

import org.jsab.jobs.matcher.engine.impl.DriversLicenceMatchCondition;
import org.jsab.jobs.matcher.model.Job;
import org.jsab.jobs.matcher.model.Worker;
import org.jsab.jobs.matcher.model.WorkerTransportation;
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
public class DriversLicenceMatchConditionTest
{
  public DriversLicenceMatchConditionTest()
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

    DriversLicenceMatchCondition myCondition = new DriversLicenceMatchCondition();

    Job myJob = new Job();
    myJob.setDriverLicenseRequired(true);
    
    Worker myWorker = new Worker();
    myWorker.setHasDriversLicense(true);
    myWorker.setTransportation(WorkerTransportation.CAR);

    assertTrue(myCondition.isMatch(myWorker, myJob));

    myWorker.setHasDriversLicense(true);
    myWorker.setTransportation(WorkerTransportation.PUBLIC_TRANSPORT);
    assertFalse(myCondition.isMatch(myWorker, myJob));
    
    myWorker.setHasDriversLicense(false);
    myWorker.setTransportation(WorkerTransportation.PUBLIC_TRANSPORT);
    assertFalse(myCondition.isMatch(myWorker, myJob));

    myJob.setDriverLicenseRequired(false);
    assertTrue(myCondition.isMatch(myWorker, myJob));
  } 
}