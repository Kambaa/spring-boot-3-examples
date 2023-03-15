# Spring Boot Demo

A basic spring boot application that has embedded H2 database and CRUD operations on it.


#### Branch TODOS: 
- [x] Add very basic example and some documentation on README.md
- [ ] Add a service layer class and make restcontroller methods call service layer class methods. 




### Follow these steps to see in action:

- Run the app
- Open http://localhost:8080/h2-console
- Enter JDBC URL: jdbc:h2:mem:testdb
- Enter User Name: sa
- Click on PERSON to auto fill Select * from PERSON, Click the Run Button. See the 5 initially added rows.
- Check data.sql to see the insert scripts.
- Call http://localhost:8080/people endpoint to list the added rows
- Call http://localhost:8080/people/1 , http://localhost:8080/people/51 for individual row data.
- Check the comments below to understand about the @SpringBootApplication annotation.
- Check Person.java to see an Entity.
- Check PersonRepository.java to see a spring JPA repository with an annotation that auto generates some REST endpoints
  to see the data.
- Check DemoController.java for the custom endpoint declarations.
- Call http://localhost:8080/addPeople to add more rows in the database
- Check the logs for the sql queries that ran and check h2-console for the newly added data.
- Check application.properties file for the h2 database setup details.

## Reading the code:

- Start with DemoApplication
- Demo controller and its methods ( You can see it in action and read the code that does the operation)
- If you are using IDEA, you can use the rest-api.http ( and http-client.env.json) file to test the endpoints.
- Person and PersonRepository
- application.properties to learn about how to connect a H2 db to spring with some customizations.
- data.sql to see the default data which is loaded when the application starts(this is done by spring).

## F.A.Q

- What are the **mwnw**, **mwn.cmd** files and **.mvn** directory for?

+ It is useful when you don't have maven installed on your system. You can call `mvnw.cmd clean compile spring-boot:run` (
  FOR WINDOWS) or `./mvnw clean compile spring-boot:run` (FOR THE OTHERS). **.mvn** directory holds the necessary files for
  this operation to run.(for extra, i have added some localization options to the JVM when maven does it's thing)

- What is the **rest-api.http** file for?

+ If you are using Idea, it has a nice functionality to write HTTP calls simple with this file. It has a nice usage to
  it. Of course you can just open up a browser and test yourself too.

### Example Tutorials to watch:

- https://www.youtube.com/watch?v=QuvS_VLbGko (Video
  REFS: https://docs.google.com/document/d/14i1qoMYjnsc7LiehVlNLRF6KfrE1yRb3CfPuD9SDSGQ)
- add new ones here...

### Links to read:

- https://www.baeldung.com/spring-data-rest-intro
- https://www.baeldung.com/spring-boot-h2-database
- https://www.baeldung.com/spring-boot-data-sql-and-schema-sql
- https://docs.spring.io/spring-boot/docs/3.0.4/reference/html/howto.html#howto.data-initialization.using-basic-sql-scripts
- https://docs.spring.io/spring-boot/docs/3.0.4/reference/html/howto.html#howto.data-access
- https://docs.spring.io/spring-boot/docs/3.0.4/reference/html/howto.html#howto.data-initialization
- https://docs.spring.io/spring-boot/docs/3.0.4/reference/html/application-properties.html
