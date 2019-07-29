package org.jsab.jobs.matcher.engine;

import org.jsab.jobs.matcher.engine.impl.CertificatesMatchCondition;
import java.util.ArrayList;
import java.util.List;
import org.jsab.jobs.matcher.model.Job;
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
public class CertificatesMatchConditionTest
{
  public CertificatesMatchConditionTest()
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
   * Test of isMatch method, of class CertificatesMatchCondition.
   */
  @Test
  public void testIsMatch()
  {
    System.out.println("testIsMatch");
    
    List<String> myJobCertificates  = new ArrayList<>();
    myJobCertificates.add("Excellence in Organization");
    myJobCertificates.add("Healthy Living Promoter");
    Job myJob = new Job();
    myJob.setRequiredCertificates(myJobCertificates);
    
    Worker myWorker = new Worker();
    List<String> myWorkerCertificates = new ArrayList<>();
    myWorkerCertificates.add("The Human Handbook");
    myWorkerCertificates.add("Outstanding Memory Award");
    myWorkerCertificates.add("Excellence in Organization");
    myWorker.setCertificates(myWorkerCertificates);
    
    CertificatesMatchCondition myCondition = new CertificatesMatchCondition();
    assertFalse(myCondition.isMatch(myWorker, myJob));

    myWorkerCertificates = new ArrayList<>();
    myWorkerCertificates.add("Healthy Living Promoter");
    myWorkerCertificates.add("Outstanding Memory Award");
    myWorkerCertificates.add("Excellence in Organization");
    myWorker.setCertificates(myWorkerCertificates);
   
    assertTrue(myCondition.isMatch(myWorker, myJob));
  }
}
