# proteus
A Spring Web MVC backend developed using Java, Spring and Hibernate.
# About
This is the backend code for the project proteus. You can find the front-end part of the application [here] (https://github.com/pumamaheswaran/proteus-ui). The backend part of the application has been developed using Java, Hibernate and Spring and is deployed on Apache Tomcat. The backend exposes a set of REST based services which the frontend consumes. A security mechanism for protecting the backend has been configured. This security mechanism uses JSON Web Tokens(JWT) which is sent with the header with each request from the web browser. A interceptor intercepts each request and checks the validity of this token and passes on the request forward if found valid.
# Technologies Used
1. Java
2. Spring MVC
3. Hibernate
4. MySQL
5. REST

