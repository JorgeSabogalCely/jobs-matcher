package org.jsab.jobs.matcher.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Objects;

/**
 *
 * @author JorgeLuis
 */
public class JobSearchAddress implements Serializable
{
  private static final long serialVersionUID = 6043914891421836723L;
 
  private DistanceUnit unit;
  private int maxJobDistance;
  private BigDecimal longitude;
  private BigDecimal latitude;

  public DistanceUnit getUnit()
  {
    return unit;
  }

  public void setUnit(DistanceUnit distanceUnit)
  {
    unit = distanceUnit;
  }

  public int getMaxJobDistance()
  {
    return maxJobDistance;
  }

  public void setMaxJobDistance(int maxJobDistance)
  {
    this.maxJobDistance = maxJobDistance;
  }

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
    hash = 37 * hash + Objects.hashCode(unit);
    hash = 37 * hash + maxJobDistance;
    hash = 37 * hash + Objects.hashCode(longitude);
    hash = 37 * hash + Objects.hashCode(latitude);
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
    
    final JobSearchAddress myOtherAddress = (JobSearchAddress) otherObject;
    return (maxJobDistance == myOtherAddress.maxJobDistance
            && Objects.equals(unit, myOtherAddress.unit)
            && Objects.equals(longitude, myOtherAddress.longitude)
            && Objects.equals(latitude, myOtherAddress.latitude));
  }
  
  @Override
  public String toString()
  {
    return MessageFormat.format("JobSearchAddress[unit:{0},maxJobDistance:{1},longitude:{2},latitude:{3}]",
            unit, maxJobDistance, longitude, latitude);
  }
}