# Backend Challenge BIT - SP

Hi!

On this repository you'll find two directories with the answers for Task 1 (task1) and Task 2(task2).

## Task 1

To build and run the task1 project:

```bash
cd task1
./mvnw spring-boot:run
```

You can also build a container:

```bash
cd task1
docker build -t task1 .
```

and run:

```bash
docker run -it -p 8080:8080 task1
```

## Task 2

On task2 dir, you'll find the answer on query.sql
