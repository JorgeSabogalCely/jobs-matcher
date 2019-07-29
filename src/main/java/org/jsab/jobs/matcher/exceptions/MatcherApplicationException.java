package org.jsab.jobs.matcher.exceptions;

/**
 * Checked exception thrown by Match Engine components when action is required from
 * callers or clients.
 */
public class MatcherApplicationException extends Exception
{
  private static final long serialVersionUID = 667783556469440399L;

  /**
   * 
   * @param errorMessage 
   */
  public MatcherApplicationException(String errorMessage)
  {
    super(errorMessage);
  }

  /**
   * 
   * @param errorMessage
   * @param rootCause 
   */
  public MatcherApplicationException(String errorMessage, Throwable rootCause)
  {
    super(errorMessage, rootCause);
  }
}