Sistema foi criado com Spring boot, para usar é só clonar com quelquer IDE e executar a classe App.java.


Request

GET http://localhost:8080/item?begindate=01-10-2016&finaldate=03-10-2016

Response

[
  {
    "name": "Celular",
    "code": "1",
    "date": [
      2016,
      10,
      1
    ],
    "dimension": {
      "weight": 10.5,
      "height": 10.5,
      "width": 10.5,
      "length": 10.5
    }
  },
  {
    "name": "Xbox",
    "code": "2",
    "date": [
      2016,
      10,
      2
    ],
    "dimension": {
      "weight": 10.5,
      "height": 10.5,
      "width": 10.5,
      "length": 10.5
    }
  },
  {
    "name": "Televisao",
    "code": "3",
    "date": [
      2016,
      10,
      3
    ],
    "dimension": {
      "weight": 10.5,
      "height": 10.5,
      "width": 10.5,
      "length": 10.5
    }
  }
]