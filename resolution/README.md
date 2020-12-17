# Backend Challenge BIT - SP

## Task 1

For this task I opted for the following technologies:
- Java 11
- Spring Boot 2.4.1

### How I developed it

I choose develop the application using the TDD methodology, where I developed the tests before developing the real application.

#### About the application

I configured the application to parse the `Date` format to the `ZonedDateTime`. With that, it is possible to send a request with the `dd-MM-yyyy` date format and the endpoint will get a date with the `yyyy-MM-dd'T'HH:mm:ss.SSSXXX` format. And, this will allow the application to filter the orders based on the date format that the [Mocky](http://www.mocky.io/v2/5817803a1000007d01cc7fc9) is returning.

To fetch the data from Mocky, I choose using the [OpenFeign](https://spring.io/projects/spring-cloud-openfeign) as my REST Client.

#### About the tests

I wrote a test for dates validation and other to validate the orders listing.

[Mockito](https://site.mockito.org/) helped me with the unit tests and [RestAssured](https://rest-assured.io/) helped with the integration one.

### How to execute

Having Maven installed in your machine (if you don't, you can download it [here](https://maven.apache.org/download.cgi)), you just need to be in the `resolution/task_1` directory and run the following command:
```
mvn spring-boot:run
```

The application will start running on the port 8080.


## Task 2

You can find the SQL resolution [here](https://github.com/LeonardoSSev/challenge-backend/blob/master/resolution/task_2/resolution.sql).

I grouped the results based on the `event_type`'s with more than one row and, using subqueries, I subtracted, from each `event_type`, the penultimate `value` from its first `value` ordering it by `event_type` and `time`.