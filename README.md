# Desafio Backend BIT - SP

Backend Challenge

$ Projeto desenvolvido com Spring Boot e Java 8, para executar o projeto, siga os seguintes passos:

$ Realize o clone do repositÛrio e dentro do Eclipse acesse Arquivo/Importar, selecione a opÁ„o Maven/Existing Maven Projects, na prÛxima tela aponte para o diretÛrio para onde foi feito o clone do projeto do git, e no final clique em Finalizar. $ abra o package br.com.b2w.app; $ Clique na classe App $ Execute o programa como se fosse um aplicativo Java, n„o È necess·rio instalar o Tomcat pois o Spring Boot j· possui ele embutido. $ Clique com o bot„o direito do mouse  e navegue para Run As > Java Application $ No console, Aguarde o servidor subir, enquanto isso abra o browser (IE, Firefox, Chrome). $ ApÛs o servidor ficar de pÈ, acesse o endereÁo: http://localhost:8080/backend-challenge/item?begindate=05-10-2016&finaldate=10-10-2016 $ O retorno s„o os dados consumidos da API de serviÁo no formato Json.

Os par‚metros begindate (data) e finaldate (data) deveram serem informados no formato dd-MM-yyyy


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

## Crit√©rios

- Qualidade e organiza√ß√£o de c√≥digo.
- Ader√™ncia aos requisitos solicitados.
- Linguagem Java 6 ou superior.
- Fica a escolha do candidato a utiliza√ß√£o de qualquer framework.


Crie um Fork desse reposit√≥rio e nos envie um **pull request**

N√£o esque√ßa de criar um README para ensinar como rodamos seu projeto :sunglasses:
