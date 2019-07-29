package org.jsab.jobs.matcher.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author JorgeLuis
 */
public enum WorkerTransportation
{
  @JsonProperty("CAR")
  CAR,

  @JsonProperty("PUBLIC TRANSPORT")
  PUBLIC_TRANSPORT
}