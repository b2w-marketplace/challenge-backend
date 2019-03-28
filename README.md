# Backend Challenge BIT - SP

#### Author: Thiago Luis Bardella dos Santos

### Task 1

This task has been developed using:
-   Java 8
-   Spring Boot Framework
-   Gradle Build Tool

Requirements:
-    To run it from terminal, gradle must be previously installed.
-    'application.properties' file has the Port used by this application. This same server port must be open.
-    Both parameters 'begindate' and 'finaldate' are required for this API call and must be on format 'dd-MM-yyyy'

To run this application, you must clone this git repository project on your local computer and either
1) Open this project as a gradle project on your favorite IDE and run the tasks 'build' and 'bootRun'

2) Or open this project and run the following commands, which will do the same effect
    ```
    gradle build
    gradle bootRun
    ```

Once the application is running, opens your browser (or run a GET API call from PostMan, Insomnia, etc.) and call the URL:

```
http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016
```

The response will be the items filtered by dates specified.


### Task 2

The directory task2, under root folder (challenge-backend), has 2 files:
1) 'task2_challenge.sql' that has the query as requested
2) 'task2_result.xlsx' with the results retrieved from applying the mentioned query on the table filled by all scripts task1_populate*.sql



