# Desafio Backend BIT - SP

Desenvolver um serviço rest que consulta a API de Item [(link da API)](http://www.mocky.io/v2/5817803a1000007d01cc7fc9) e com base no resultado realiza um filtro pela data de acordo com os parametros enviados na requisição HTTP.

O serviço deve atender a seguinte definição:

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

## Critérios

- Qualidade e organização de código.
- Aderência aos requisitos solicitados.
- Linguagem Java 6 ou superior.
- Fica a escolha do candidato a utilização de qualquer framework.


Crie um Fork desse repositório e nos envie um **pull request**

Não esqueça de criar um README para ensinar como rodamos seu projeto :sunglasses:
