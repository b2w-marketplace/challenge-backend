# Backend Challenge BIT - SP

1) Develop a rest service that uses this Order API [(link)](http://www.mocky.io/v2/5817803a1000007d01cc7fc9) and, based on the result, filters by data according to the parameters sent by HTTP request.
The service must follow this definition:

#### Request
```
GET http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016
```
#### Response
```
[
  {
    "name": "Impressora",
    "code": "5",
    "date": "2016-10-05T14:30:37.040Z",
    "dimension": {
      "weight": 10.5,
      "height": 10.5,
      "width": 10.5,
      "length": 10.5
    }
  },
  {
    "name": "Fifa2017",
    "code": "6",
    "date": "2016-10-06T14:30:37.040Z",
    "dimension": {
      "weight": 10.5,
      "height": 10.5,
      "width": 10.5,
      "length": 10.5
    }
  },
  .
  .
  .
]
```

## Criterias for this task:
- Quality and organization of the code;
- Pay attention to the requirements;
- Use Java 6 or newer (or Elixir language)
- The candidate can choose any framework

Do not forget to create a README to tell us how to run the project :sunglasses:

2) Given a table events with the following structure:
```
create table events (
  event_type integer not null,
  value integer not null,
  time timestamp not null,
  unique (event_type, time)
);
```
write an SQL (MySQL) query that, for each event_type that has been registered more than once,
returns the difference between the penultimate and the oldest value (in terms of time) . The table
should be ordered by event_type (in ascending order).
For example, given the following data:

|event_type  | value  | time                |
|----------- | -----  | -------------------
|2           | 5      | 2015-05-09 12:42:00 |
|4           | -42    | 2015-05-09 13:19:57 |
|2           | 2      | 2015-05-09 14:48:30 |
|2           | 7      | 2015-05-09 12:54:39 |
|3           | 16     | 2015-05-09 13:19:57 |
|3           | 20     | 2015-05-09 15:01:09 |


Your query should return the following rowset:

|event_type | value |
|---------- | -----
|2          | 2     |
|3          | 0     |

For example, for the event_type 2, the penultimate value is a 7 and the oldest value is 5, so the
difference between them is 2.
The name of the columns in the rowset don’t matter, but their order does.


## Criterias for this task:
- See the directory task2 to solve the second question
- Create a file and put the result of the query

Create a Fork of this project and send us a pull request


