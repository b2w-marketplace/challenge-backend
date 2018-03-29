# Desafio Backend BIT - SP

Backend Challenge

Projeto desenvolvido com Spring Boot e Java 8, para executar o projeto, siga os seguintes passos:

- Realize o clone do reposit�rio e dentro do Eclipse acesse Arquivo/Importar, selecione a op��o Maven/Existing Maven Projects, na pr�xima tela aponte para o diret�rio para onde foi feito o clone do projeto do git, e no final clique em Finalizar. 

- Abra o package br.com.b2w.app; 

- Clique na classe App 

- Execute o programa como se fosse um aplicativo Java, n�o � necess�rio instalar o Tomcat pois o Spring Boot j� possui ele embutido. 

- Clique com o bot�o direito do mouse  e navegue para Run As > Java Application $ No console, Aguarde o servidor subir, enquanto isso abra o browser (IE, Firefox, Chrome). 

- Ap�s o servidor ficar de p�, acesse o endere�o: http://localhost:8080/backend-challenge/item?begindate=05-10-2016&finaldate=10-10-2016 

- O retorno s�o os dados consumidos da API de servi�o no formato Json conforme response abaixo.

Os par�metros begindate (data) e finaldate (data) deveram serem informados no formato dd-MM-yyyy


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

## Autor

### Rafael Felix de Moraes

### <a href="mailto:rafaelfelix1433@gmail.com?Subject=Java%20B2W" target="_top">Envie-me um E-mail</a>

