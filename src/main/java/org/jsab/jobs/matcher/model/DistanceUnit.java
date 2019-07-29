package org.jsab.jobs.matcher.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author JorgeLuis
 */
public enum DistanceUnit
{
  @JsonProperty("km")
  KM,

  @JsonProperty("m")
  STATUTE_MILES,

  @JsonProperty("n")
  NAUTICAL_MILES
}