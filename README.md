## SPRING BOOT 3 OPENAPI UI setup

This example is to show how easy it is to use the openapi-ui to your project and
expose a web page which you can test your endpoints and read its documentation.

To enable this functionality on spring boot 3, add this dependency to your **pom.xml**

```xml

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.0.4</version>
</dependency>

```

When you run your application you can access at: http://localhost:8080/swagger-ui.html

Some basic functionality configurations to add to your _application.properties_:

- To change swagger-ui.html to something else `springdoc.swagger-ui.path=/swagger-ui.html`
- To disable the /v3/api-docs configuration json display `#springdoc.api-docs.enabled=false`
- To disable the swagger-ui `#springdoc.swagger-ui.enabled=false`

### LINKS TO READ:

- https://springdoc.org/v2/#getting-started
- https://springdoc.org/v2/#properties
- https://www.baeldung.com/spring-rest-openapi-documentation (good for first impressions and general knowlegde, but did
  not work for me on spring boot 3)


### TODOS
[X] Add basic openapi-ui functionality
[X] Add basic configurations (disable json, disable swagger-ui.html page)
[ ] Add basic OpenAPI related annotations
[ ] Add optional/required input example
[ ] Add input consisting of Lists
[ ] Add security related configurations:
   - [ ] Endpoint needing username password info on its headers.
   - [ ] Endpoint needing some header token(s)
   - [ ] Endpoint needing Oauth 1/2
   - [ ] Search, learn and write examples of other (if exists) endpoint security config on openapi-ui.
[ ] Generate another example branch of this topic as 'advanced'. 
