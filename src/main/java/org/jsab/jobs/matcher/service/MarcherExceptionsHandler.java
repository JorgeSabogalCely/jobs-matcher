package org.jsab.jobs.matcher.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.jsab.jobs.matcher.exceptions.MatcherApplicationException;
import org.jsab.jobs.matcher.exceptions.MatcherArgumentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author JorgeLuis
 */
@ControllerAdvice
public class MarcherExceptionsHandler
{
  @ResponseBody
  @ExceptionHandler(MatcherApplicationException.class)
  //@ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> handleMatcherException(MatcherApplicationException exception)
  {
    return new ResponseEntity<>(toJson(exception), HttpStatus.NOT_FOUND);
  }

  @ResponseBody
  @ExceptionHandler(MatcherArgumentException.class)
  //@ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> handleMatcherException(MatcherArgumentException exception)
  {
    return new ResponseEntity<>(toJson(exception), HttpStatus.NOT_FOUND);
  }
  
  private static ObjectNode toJson(Exception exception)
  {
    ObjectMapper myJsonMapper = new ObjectMapper();
    ObjectNode myJsonProp = myJsonMapper.createObjectNode();
    myJsonProp.put("errorMessage",  exception.getMessage());
    
    return myJsonProp;
  }
}