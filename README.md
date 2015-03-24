# Simple Spring Example (spring-simple-web)

This simple example demonstrates Spring container being used in a web application, i.e. `org.springframework.web.context.WebApplicationContext`
* The web application is initialized with Spring web listener, e.g. `org.springframework.web.context.ContextLoaderListener` in `web.xml`.
* The Spring web listener is initialized with the `contextConfigLocation` context parameter in `web.xml`. Default value for this setting is `WEB-INF/applicationContext.xml`. We have defined this value to be `classpath:applicationContext.xml`. This file represents the configuration of the Spring container.
* We have configured a web servlet, e.g. `example.web.TimeServlet`. The servlet is initialized using static utility method of `org.springframework.web.context.support.WebApplicationContextUtils`, e.g. `WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext())`.
* The servlet requests an instance of `example.services.TimeService` for every request it serves. Based on Spring container configuration, the container would return the same or new instance on every web request being served, e.g. based on `singleton` vs `prototype` bean scope.

## Build JAR

* `mvn package` - builds a war file, e.g. `target/spring-simple-web.war`

## Run example

* `mvn tomcat7:run` - runs the application in embedded Tomcat7, as specified in `pom.xml`, or
* Copy target/spring-simple-web.war to a running Tomcat7 (Tomcat8) instance.

## Import project to Eclipse
1. Right click in your Project Explorer
2. Select `Import...`
3. Select `Maven`
4. Select `Check out Maven Projects from SCM`
5. Select SCM URL as `git` and type in `https://github.com/javaclinic/spring-simple-web.git`
6. Select `Finish`
7. Right click on newly created project, e.g. `spring-simple-web`
8. Select `Maven`
9. Select `Update Project ... ALT+F5`
10. Select `OK`

