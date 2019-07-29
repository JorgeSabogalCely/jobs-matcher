package org.jsab.jobs.matcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Spring Boot Application, entry point for the Jobs Match Engine service.
 * 
 * @author JorgeLuis
 */
@EnableCaching
@SpringBootApplication
public class JobsMatchEngineApp
{
  public static void main(String[] args)
  {
    SpringApplication.run(JobsMatchEngineApp.class, args);
  }
}