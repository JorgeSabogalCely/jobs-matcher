# Jobs Match Engine

A simple matching engine that presents Workers with appropriate Jobs. 

# Version

* 1.0.1-SNAPSHOT

## Prerequisites

* JDK 1.8
* Maven 3

## Project Description

* **org.jsab.jobs.matcher.JobsMatchEngineApp** - SpringBoot aplication, entry point for the Match Engine Web API. It enables caching.
* **org.jsab.jobs.matcher.service.JobsMatchEngineController** - RESTful service for the implemente Match Engine web-api. It requires an instance of *JobsMatchEngine*.
* **org.jsab.jobs.matcher.engine.JobsMatchEngine** - Interface that defines Jobs Match Engine functionality.
* **org.jsab.jobs.matcher.engine.impl.JobsMatchEngineImpl** - Default implementation of *JobsMatchEngine*. It requires an instance of *DataAPIConnector*.
* **org.jsab.jobs.matcher.dataapi.DataAPIConnector** - Interface that defines connector to existing 'jobs' API to retrieve available jobs and workers data.
* **org.jsab.jobs.matcher.dataapi.impl.RestDataAPIConnector** - Implementation of *DataAPIConnector* as a RESTful client. It connects to 'jobs' web-API.
* **org.jsab.jobs.matcher.model.Job** - POJO to define job information.
* **org.jsab.jobs.matcher.model.Worker** - POJO to define worker information.

* **pom.xml** - Maven project descriptor.

## SpringBoot Starters

SpringBoot version 2.1.4.RELEASE is used, using three maven starters:

* **spring-boot-starter-cache** - For caching service with EHCache framework.
* **spring-boot-starter-web** - For RESTful service on Apache Tomcat server.
* **spring-boot-starter-test** - For testing Spring Boot application.

## JSON Mapper

Project uses Jackson framework for JSON serialisation and deserialisation. SpringBoot 2.1.4.RELEASE uses Jackson libraries 2.9.8.

## Cache Manager

* **EHCache** - Configuration of caches in src/main/resources/ehcache.xml. Specification of EHCache as cache manager for Spring Boot in src/main/resources/application.properties.

Defined caches:

* **workers** - Cache for responses recevied from 'workers' api.
* **jobs** - Cache for responses recevied from 'jobs' api.
* **jobsPerWorker** - Cache for responses sent to MatchEngine clients.

## Building

Maven is used to build the project and running all included tests.

```
> mvn clean install
```

The generated artifact is:

* target/jobs-match-engine-1.0.1-SNAPSHOT.jar

## Execution

To run the SpringBoot applicaton:

```
> java -jar target/jobs-match-engine-1.0.1-SNAPSHOT.jar
```

Access URL for the Match Engine web-API is:

* http://localhost:8080/match/jobs/{workerId}

For example:
* http://localhost:8080/match/jobs/0
* http://localhost:8080/match/jobs/7
