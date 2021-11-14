# Introduction 
 This project was developed with the aim of testing differents use cases of unit and integration tests

### Requirements
- [Java 11](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html) ou superior
- [Maven](https://maven.apache.org/install.html)
- [Docker](https://docs.docker.com/install/)
- [Docker Compose](https://docs.docker.com/compose/install/)

### Getting Started
1) Clone or download the project
2) Use the follow command to build the project
 ```
 mvn clean install
 ```
3) Start the mongodb database
 ```
 docker-compose up
 ```
4) The last step is execute the spring application
 ```
 mvn spring-boot:run
 ```
