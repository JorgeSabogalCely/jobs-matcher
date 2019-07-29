package org.jsab.jobs.matcher.model;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Objects;

/**
 *
 * @author JorgeLuis
 */
public class WorkerFullName implements Serializable
{
  private static final long serialVersionUID = -5408665421853935825L;

  private String last;
  private String first;

  public String getLast()
  {
    return last;
  }

  public void setLast(String lastName)
  {
    last = lastName;
  }

  public String getFirst()
  {
    return first;
  }

  public void setFirst(String firstName)
  {
    first = firstName;
  }

  @Override
  public int hashCode()
  {
    int hash = 7;
    hash = 71 * hash + Objects.hashCode(last);
    hash = 71 * hash + Objects.hashCode(first);
    return hash;
  }

  @Override
  public boolean equals(Object otherObject)
  {
    if (this == otherObject) {
      return true;
    }
    
    if (otherObject == null || getClass() != otherObject.getClass()) {
      return false;
    }
    
    final WorkerFullName myOtherFullName = (WorkerFullName) otherObject;
    return Objects.equals(last, myOtherFullName.last) && Objects.equals(first, myOtherFullName.first);
  }
 
  @Override
  public String toString()
  {
    return MessageFormat.format("WorkerFullName[first:{0},last:{1}]", first, last);
  }
}