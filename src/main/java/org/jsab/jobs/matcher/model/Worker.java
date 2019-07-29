package org.jsab.jobs.matcher.model;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author JorgeLuis
 */
public class Worker implements Serializable
{
  private static final long serialVersionUID = -1341716260455536907L;
  
  private String guid;
  private long userId;
  private WorkerFullName name;
  private int rating;
  private boolean active;
  private List<String> certificates;
  private List <String> skills;
  private JobSearchAddress jobSearchAddress;
  private WorkerTransportation transportation;
  private boolean hasDriversLicense;
  private List<WorkerAvailability> availability;
  private String phone;
  private String email;
  private int age;

  public String getGuid()
  {
    return guid;
  }

  public void setGuid(String guid)
  {
    this.guid = guid;
  }

  public long getUserId()
  {
    return userId;
  }

  public void setUserId(long userId)
  {
    this.userId = userId;
  }

  public WorkerFullName getName()
  {
    return name;
  }

  public void setName(WorkerFullName name)
  {
    this.name = name;
  }

  public int getRating()
  {
    return rating;
  }

  public void setRating(int workerRating)
  {
    rating = workerRating;
  }

  public boolean getIsActive()
  {
    return active;
  }

  public void setIsActive(boolean isActiveWorker)
  {
    active = isActiveWorker;
  }

  public List<String> getCertificates()
  {
    return certificates;
  }

  public void setCertificates(List<String> workerCertificates)
  {
    certificates = workerCertificates;
  }

  public List<String> getSkills()
  {
    return skills;
  }

  public void setSkills(List<String> workerSkills)
  {
    skills = workerSkills;
  }

  public JobSearchAddress getJobSearchAddress()
  {
    return jobSearchAddress;
  }

  public void setJobSearchAddress(JobSearchAddress jobSearchAddress)
  {
    this.jobSearchAddress = jobSearchAddress;
  }

  public WorkerTransportation getTransportation()
  {
    return transportation;
  }

  public void setTransportation(WorkerTransportation workerTransportation)
  {
    transportation = workerTransportation;
  }

  public boolean isHasDriversLicense()
  {
    return hasDriversLicense;
  }

  public void setHasDriversLicense(boolean hasDriversLicense)
  {
    this.hasDriversLicense = hasDriversLicense;
  }

  public List<WorkerAvailability> getAvailability()
  {
    return availability;
  }

  public void setAvailability(List<WorkerAvailability> availability)
  {
    this.availability = availability;
  }

  public String getPhone()
  {
    return phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  @Override
  public int hashCode()
  {
    int hash = 5;
    hash = 67 * hash + Objects.hashCode(guid);
    hash = 67 * hash + (int) (userId ^ (userId >>> 32));
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
    
    final Worker myOtherWorker = (Worker) otherObject;
    return userId == myOtherWorker.userId && Objects.equals(guid, myOtherWorker.guid);
  }
  
  @Override
  public String toString()
  {
    return MessageFormat.format("Worker[userId:{0},guid:{1},name:{2},active:{3},rating:{4},certificates:{5},skills:{6},"
            + "jobSearchAddress:{7},transportation:{8},hasDriversLicense:{9},availability:{10},phone:{11},email:{12},"
            + "age:{13}]",
            userId, guid, name, active, rating, certificates, skills, jobSearchAddress, transportation,
            hasDriversLicense, availability, phone, email, age);
  }      
}