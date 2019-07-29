package org.jsab.jobs.matcher.model;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author JorgeLuis
 */
public class Job implements Serializable
{
  private static final long serialVersionUID = -5042734279979260922L;

  private long jobId;
  private String guid;
  private String jobTitle;
  private String company;
  private boolean driverLicenseRequired;
  private List<String> requiredCertificates;
  private JobLocation location;
  private String billRate;
  private int workersRequired;
  private String startDate;
  private String about;

  public String getGuid()
  {
    return guid;
  }

  public void setGuid(String guid)
  {
    this.guid = guid;
  }

  public long getJobId()
  {
    return jobId;
  }

  public void setJobId(long jobId)
  {
    this.jobId = jobId;
  }

  public String getJobTitle()
  {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle)
  {
    this.jobTitle = jobTitle;
  }

  public String getCompany()
  {
    return company;
  }

  public void setCompany(String company)
  {
    this.company = company;
  }

  public boolean isDriverLicenseRequired()
  {
    return driverLicenseRequired;
  }

  public void setDriverLicenseRequired(boolean driverLicenseRequired)
  {
    this.driverLicenseRequired = driverLicenseRequired;
  }

  public List<String> getRequiredCertificates()
  {
    return requiredCertificates;
  }

  public void setRequiredCertificates(List<String> requiredCertificates)
  {
    this.requiredCertificates = requiredCertificates;
  }

  public JobLocation getLocation()
  {
    return location;
  }

  public void setLocation(JobLocation location)
  {
    this.location = location;
  }

  public String getBillRate()
  {
    return billRate;
  }

  public void setBillRate(String billRate)
  {
    this.billRate = billRate;
  }

  public int getWorkersRequired()
  {
    return workersRequired;
  }

  public void setWorkersRequired(int workersRequired)
  {
    this.workersRequired = workersRequired;
  }

  public String getStartDate()
  {
    return startDate;
  }

  public void setStartDate(String startDate)
  {
    this.startDate = startDate;
  }

  public String getAbout()
  {
    return about;
  }

  public void setAbout(String about)
  {
    this.about = about;
  }

  @Override
  public int hashCode()
  {
    int hash = 5;
    hash = 29 * hash + Objects.hashCode(guid);
    hash = 29 * hash + (int) (jobId ^ (jobId >>> 32));
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
    
    final Job myOtherJob = (Job) otherObject;
    return jobId == myOtherJob.jobId && Objects.equals(guid, myOtherJob.guid);
  }
  
  @Override
  public String toString()
  {
    return MessageFormat.format("Job[jobId:{0},guid:{1},jobTitle:{2},company:{3},driverLicenseRequired:{4},"
             + "requiredCertificates:{5},location:{6},billRate:{7},workersRequired:{8},startDate:{9},about:{10}]", 
             jobId, guid, jobTitle, company, driverLicenseRequired, requiredCertificates, location, billRate,
             workersRequired, startDate, about);
  }
}