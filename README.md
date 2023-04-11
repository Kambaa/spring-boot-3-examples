## Spring Boot Demo

A basic spring boot application that has embedded H2 database and CRUD operations on it.


### Branch TODOS:
- TBD




### Follow these steps to see in action:

- Run the app
- Open http://localhost:8080/h2-console
- Enter JDBC URL: jdbc:h2:mem:testdb
- Enter User Name: sa
- Click on PERSON to auto fill Select * from PERSON, Click the Run Button. See the 5 initially added rows.
- Check data.sql to see the insert scripts.
- Call http://localhost:8080/people endpoint to list the added rows
- Call http://localhost:8080/person/1 , http://localhost:8080/person/2 for individual row data.
- Check the comments below to understand about the @SpringBootApplication annotation.
- Check Person.java to see an Entity.
- Check PersonRepository.java to see a spring JPA repository with an annotation that auto generates some REST endpoints
  to see the data.
- Check DemoController.java for the custom endpoint declarations.
- Check application.properties file for the h2 database setup details.
- Check the logs for the sql queries that ran, and check the hibernate caching logs, and check the SecondLevelCacheVisualizer logs that logs the data schedually.

## Reading the code:

- TBD 

## F.A.Q

- TBD

### Example Tutorials to watch:

- TBD


### Links to read:

- TBD
