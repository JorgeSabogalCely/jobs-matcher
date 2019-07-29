package org.jsab.jobs.matcher.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jsab.jobs.matcher.exceptions.MatcherApplicationException;
import org.jsab.jobs.matcher.model.Job;
import org.jsab.jobs.matcher.model.Worker;
import org.jsab.jobs.matcher.dataapi.DataAPIConnector;

/**
 *
 * @author JorgeLuis
 */
public class MockAPIConnector implements DataAPIConnector
{
  @Override
  public Map<Long, Worker> retrieveWorkers() throws MatcherApplicationException
  {
    Worker[] myWorkers = null;

    try {
      myWorkers = deserialiseJson("/test-workers.json", Worker[].class);
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }

    if (myWorkers == null || myWorkers.length == 0) {
      throw new MatcherApplicationException("Workes information not available");
    }

    return Arrays.asList(myWorkers).stream().collect(Collectors.toMap(Worker::getUserId, worker -> worker));
  }

  @Override
  public List<Job> retrieveJobs() throws MatcherApplicationException
  {
    Job[] myJobs = null;

    try {
      myJobs = deserialiseJson("/test-jobs.json", Job[].class);
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }

    if (myJobs == null || myJobs.length == 0) {
      throw new MatcherApplicationException("Jobs information not available");
    }

    return Arrays.asList(myJobs);
  }

  private <T> T deserialiseJson(String jsonResourceName, Class<T> targetClass) throws Exception
  {
    ObjectMapper myObjectMapper = new ObjectMapper();
    return myObjectMapper.readValue(getClass().getResource(jsonResourceName), targetClass);
  }
}