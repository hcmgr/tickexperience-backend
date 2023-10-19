# Brisbane 2023 Gold Pass

<p align="center">
  <img src="https://github.com/Wo-m/tickexperience-frontend/blob/main/src/assets/images/logo.png?raw=true)" alt="logo" width="250"/>
</p>

The Brisbane 2032 Gold Pass is a new web application looking to revolutionise the ticketing experience in the leadup to the 2032 Brisbane Olympic Games. For more general information on the project, visit the frontend repository [here](https://github.com/Wo-m/tickexperience-frontend)

This repository contains the backend for frontend, which handles API requests and interacts directly with the database system. This implementation uses Java (Spring Framework) and a local H2 database.

## Getting started
The following is a brief overview of how to navigate this code-base/how it works.
- The three main entities are:
    - models
    - controllers
    - services
- Models:
    - these represent the entities of the backend, and loosely map to tables in the DB schema
    - annotations (ie: '@' expressions above variables) specify how java spring is to view/use the given member variables of a model
- Controllers:
    - these represent the end points of our backend API
    - it is a lightweight class that maps an API request to a 'service' method call
- Service:
    - services represent the main logic of the app
    - all calls to the DB go through a service
    - also handles non-entity related functionality such as email sending (EmailService) and encryption (EncryptionService)

## Usage
In order to run this codebase please install the latest version of [Java 17](https://www.oracle.com/au/java/technologies/downloads/#java17), as well as [Apache Maven](https://maven.apache.org/)
Once installed, in the root folder run `mvn clean install` to compile the project and all of its dependencies and `mvn spring-boot:run` to run the project.

## Software Used
- [Java 17](https://www.oracle.com/au/java/technologies/downloads/)
- [Java Spring Framework](https://spring.io/)
- [H2 Embedded Database](https://www.h2database.com/html/main.html)
- [Liquibase](https://www.liquibase.org/)
- [Lombok](https://projectlombok.org/)
