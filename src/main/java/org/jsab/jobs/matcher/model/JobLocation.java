package org.jsab.jobs.matcher.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Objects;

/**
 *
 * @author JorgeLuis
 */
public class JobLocation implements Serializable
{
  private static final long serialVersionUID = 6413437849320696340L;

  private BigDecimal longitude;
  private BigDecimal latitude;

  public BigDecimal getLongitude()
  {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude)
  {
    this.longitude = longitude;
  }

  public BigDecimal getLatitude()
  {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude)
  {
    this.latitude = latitude;
  }

  @Override
  public int hashCode()
  {
    int hash = 7;
    hash = 17 * hash + Objects.hashCode(this.longitude);
    hash = 17 * hash + Objects.hashCode(this.latitude);
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
    
    final JobLocation myOtherLocation = (JobLocation) otherObject;
    return (Objects.equals(longitude, myOtherLocation.longitude)
            && Objects.equals(latitude, myOtherLocation.latitude));
  }  
  
  @Override
  public String toString()
  {
    return MessageFormat.format("JobLocation[longitude:{0},latitude:{1}]", longitude, latitude);
  }
}