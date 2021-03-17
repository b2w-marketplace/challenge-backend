# Task 1

## Dependencies

* Java 11
* Spring Boot 2.4.3
* Spring Web 2.4.3
* Lombok 1.18.18
* OpenFeign 3.0.1

## Getting started

Run project:

```
    mvn spring-boot:run
```

## Notes

* Both route parameters are optional;
* Route parameters are all in lower case since they are defined that way in the test specification;
* For the returned items from Mocky API with date as null: if both route parameters are null, then the item is included
  in the response, otherwise not;
* All the date and time values received from Mocky API are converted to the system time zone before comparing with the
  unzoned dates ("begindate" and "finaldate" params doesn't include a time zone, so without converting it's like
  comparing apples and oranges);
* All classes in the dto package are immutable (by Lombok's @Value annotation);

