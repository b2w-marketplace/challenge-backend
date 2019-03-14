# Backend Challenge BIT - SP

Develop a rest service that uses this Order API and, based on the result, filters by data according to the parameters sent by HTTP request.
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

## Criterias:
Quality and organization of the code;
Pay attention to the requirements;
Use Java 6 or newer (or Elixir language)
The candidate can choose any framework

Create a Fort of this project and send us a pull request

Do not forgive to create a README to tell us how to run the project :sunglasses:
