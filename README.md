## Spring Boot H2 Database With Hibernate 2nd Level Cache Demo

A basic spring boot application that has embedded H2 database and hibernate 2nd level cache working with hazelcast set up on it.

### Branch TODOS:

- TBD

### Follow these steps to see in action:

- Run the app
- Open http://localhost:8080/h2-console
- Enter JDBC URL: jdbc:h2:mem:testdb
- Enter User Name: sa
- Click on Demo to auto fill Select * from Demo, Click the Run Button. See the 15 initially added rows.
- Check data.sql to see the insert scripts.
- Call http://localhost:8080/people endpoint to list the added rows
- Call http://localhost:8080/person/1 , http://localhost:8080/person/2 for individual row data.
- Check the comments to understand about the @SpringBootApplication annotation.
- Check DemoEntity.java to see an Entity.
- Check DemoRepository.java to see a spring JPA repository 
- Check DemoController.java for the custom endpoint declarations.
- Check application.properties file for the h2 database jpa and 2nd level cache setup details.
- Check the logs for the sql queries that ran, and check the hibernate caching logs, and check the
  SecondLevelCacheVisualizer logs that logs the data schedually.

## Reading the code:

- TBD

## F.A.Q

- TBD

### Example Tutorials to watch:

- TBD

### Links to read:

- https://github.com/hazelcast-guides/springboot-hibernate
- https://docs.hazelcast.com/tutorials/springboot-hibernate
- https://github.com/hazelcast/hazelcast-hibernate#spring-boot-configuration
- https://www.baeldung.com/hibernate-second-level-cache
- https://docs.oracle.com/javaee/7/tutorial/persistence-cache001.htm
- https://stackoverflow.com/questions/2351004/how-to-know-log-whether-hibernate-2nd-level-cache-was-used-or-not-for-a-query
- https://stackoverflow.com/questions/3156133/hibernate-second-level-cache-print-result
- https://medium.com/@premrajsahu/spring-boot-caching-with-hazelcast-and-spring-data-jpa-a190fd4f9c39
- https://www.quora.com/How-do-I-enable-a-Level-2-cache-in-a-Spring-Boot-application/answer/Jeet-Singh-Parmar-1?share=be339b8f&srid=xLIQ
- https://vladmihalcea.com/how-does-hibernate-query-cache-work/
