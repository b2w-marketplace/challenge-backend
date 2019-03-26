# Backend Challenge BIT - SP [![Build Status](https://travis-ci.org/hashiCode/challenge-backend.svg?branch=master)](https://travis-ci.org/hashiCode/challenge-backend) [![Coverage Status](https://coveralls.io/repos/github/hashiCode/challenge-backend/badge.svg?branch=master)](https://coveralls.io/github/hashiCode/challenge-backend?branch=master) 


### Rest Service 
To run the application, use the `start.sh` script.
```
./start.sh
```

Sent a http request according to the definition bellow:
```
GET http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016
```
Where `begindate` and `finaldate` __must__ be in `dd-MM-yyyy`.

Develop with:

- Java 8
- Maven
- Spring Boot
- Spock framework

### Query
The query is located inside _task2_, in a file called `query.sql`.


