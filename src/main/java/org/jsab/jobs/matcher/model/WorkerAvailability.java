package org.jsab.jobs.matcher.model;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Objects;
/**
 *
 * @author JorgeLuis
 */
public class WorkerAvailability implements Serializable
{
  private static final long serialVersionUID = 4385911819732156905L;
  
  private String title;
  private int dayIndex;

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public int getDayIndex()
  {
    return dayIndex;
  }

  public void setDayIndex(int dayIndex)
  {
    this.dayIndex = dayIndex;
  }

  @Override
  public int hashCode()
  {
    int hash = 3;
    hash = 43 * hash + Objects.hashCode(title);
    hash = 43 * hash + dayIndex;
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

    final WorkerAvailability myOtherAvailability = (WorkerAvailability) otherObject;
    return (dayIndex == myOtherAvailability.dayIndex
            && Objects.equals(this.title, myOtherAvailability.title));
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("WorkerAvailability[title:{0},dayIndex:{1}]", title, dayIndex);
  }  
}
