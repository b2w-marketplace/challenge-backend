# challeng-backend-1
Is a Spring Boot based application exposing a REST API to get orders 
filters by data.

## Tech stack
The application is based on the following projects:

* **Spring boot** 2.5.0-SNAPSHOT
* **Spring cloud** 2020.0.2-SNAPSHOT
* **JUnit** 4.13.2
* **Mockito** 3.8.0
* **Maven** 3.8.1
* **Project Lombok** 1.18.18
* **Java** 11

## Software Principles
* Clean Architecture: software design principles that allow for SOLID layering of the app, making the app scalable, agile and robust.
* Test-Driven Development: technique that allows abstractions to be readily tested, as a way to ensure robust feature development, allowing failures to happen as soon as possible, so they can be fixed before detailed implementation

## How To Run Locally
* Run the backend application. Make sure you have Java and Maven installed.
----
* $ git clone https://github.com/andre-paschoal/challenge-backend  <1>
* $ cd challenge-backend/task1 <2>
* $ mvn spring-boot:run <3>
----
<1> Clone the repository.
<2> Switch to the `task1` folder (root folder, same as pom.xml)
<3> Run the application
----
Your app should now be running on [localhost:8081](http://localhost:8081/).
Gracefully shutdown hit `ctrl+c`.

## How to Call Endpoints
`$ http GET:8081/challenge-backend/item?beginDate=dd-MM-yyyy&finalDate=dd-MM-yyyy`
