package org.jsab.jobs.matcher.exceptions;

/**
 * Unchecked exception thrown by Match Engine components during execution when immediate action
 * is not required from callers or clients.
 */
public class MatcherArgumentException extends RuntimeException
{
  private static final long serialVersionUID = -4047095611411453549L;

  /**
   * 
   * @param errorMessage 
   */
  public MatcherArgumentException(String errorMessage)
  {
    super(errorMessage);
  }
}