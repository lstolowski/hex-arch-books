# Hexagonal architecture example: Books catalogue

## Architecture

Project is divided into 3 main parts:
- [domain](domain) - contains business domain objects and business logic and ports as interfaces
- [adapter](adapter) - contains adapter layer with ports implementations so called adapters
- [application](application) - which is a Spring Boot application, configuration, logic needed for Spring boot working etc

It also contains some technical folders such: 
- [e2e-tests-rest-client](e2e-tests-rest-client) contains usefull rest client (IntelliJ) with some e2e tests
- [buildSrc](buildSrc) which is a technical folder with gradle common configuration


### Domain

Contains business objects and logic (not many use cases are now implemented, see [BookValidator.java](domain%2Fsrc%2Fmain%2Fjava%2Fcom%2Fgithub%2Flstolowski%2Fhexbooks%2Fdomain%2Fmodel%2Fbook%2Fvalidation%2FBookValidator.java)).

Domain logic and data is exposed outside by the primary ports called [api](domain%2Fsrc%2Fmain%2Fjava%2Fcom%2Fgithub%2Flstolowski%2Fhexbooks%2Fdomain%2Fport%2Fapi).

For internal (business purposes) it uses secendary ports called [spi](domain%2Fsrc%2Fmain%2Fjava%2Fcom%2Fgithub%2Flstolowski%2Fhexbooks%2Fdomain%2Fport%2Fspi) 
to reach the information needed for the business (like goodreads.com integration for fetching pics) or allow side effects (like DB or Elasticsearch etc).

Should not contain any dependencies (only libs allowed for dev convenience).

### Adapter

Implementation of ports from the `domain`. It contains both, internal and external, communication like DB communication, goodreads (outside world), ES, and REST api endpoints (Spring rest controllers)

## Local run

### DB 
Application needs a DB to run:
```
docker compose up
```
The database (Postgres) is filed up with a data with automatic schema creation, each time the context is started. So ***after app restart the data will be lost***.

There should be a migration mechanism like flyway or liquibase but I had no time to configure it. 

### Spring Boot
Start the app as a normal Spring boot application with some endpoints available

```
GET http://localhost:8080/actuator/health

POST http://localhost:8080/api/book
GET http://localhost:8080/api/book/list
```

### Rest client implemented

[e2e-tests-rest-client](e2e-tests-rest-client) folder contains a simple [client.rest](e2e-tests-rest-client%2Fclient.rest) which can be run on the IntelliJ IDEA.

Just tweak the POST payload and push "play" button. It also works as a simple test with assertions.

You can of course use other rest clients like Postman etc.
