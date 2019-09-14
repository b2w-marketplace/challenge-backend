FROM zenika/alpine-maven:3-jdk8 as build-stage

WORKDIR /task1
COPY . .

RUN ./mvnw package

FROM openjdk:14-jdk-alpine3.10
COPY --from=build-stage /task1/target/task1-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
