package org.jsab.jobs.matcher.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.jsab.jobs.matcher.JobsMatchEngineApp;
import org.jsab.jobs.matcher.model.Job;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

/**
 *
 * @author JorgeLuis
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {JobsMatchEngineApp.class})
@WebAppConfiguration
public class JobsMatchEngineAppTest
{
  private MockMvc mvc;
  
  @Autowired
  private WebApplicationContext webApplicationContext;
  
  @Before
  public void setUp()
  {
    mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }
  
  @Test
  public void findJobsForWorker0() throws Exception
  {
    String myURI = "/match/jobs/0";
    MvcResult myRSResult = mvc.perform(MockMvcRequestBuilders.get(myURI)).andReturn();

    int myStatusCode = myRSResult.getResponse().getStatus();
    assertEquals(200, myStatusCode);
    
    String content = myRSResult.getResponse().getContentAsString();
    
    Job[] myJobs = deserialiseJson(content, Job[].class);
    assertEquals(2, myJobs.length);
  }
  
  @Test
  public void findJobsForWorker1() throws Exception
  {
    String myURI = "/match/jobs/1";
    MvcResult myRSResult = mvc.perform(MockMvcRequestBuilders.get(myURI)).andReturn();

    int myStatusCode = myRSResult.getResponse().getStatus();
    assertEquals(200, myStatusCode);
    
    String content = myRSResult.getResponse().getContentAsString();
    
    Job[] myJobs = deserialiseJson(content, Job[].class);
    assertEquals(0, myJobs.length);
  }

  protected <T> T deserialiseJson(String json, Class<T> targetClass)
    throws JsonParseException, JsonMappingException, IOException
  {
    ObjectMapper myObjectMapper = new ObjectMapper();
    return myObjectMapper.readValue(json, targetClass);
  }
}
