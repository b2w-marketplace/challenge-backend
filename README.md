# Desafio Backend BIT - SP

Backend Challenge

Projeto desenvolvido com Spring Boot e Java 8, para executar o projeto, siga os seguintes passos:

- Realize o clone do repositório e dentro do Eclipse acesse Arquivo/Importar, selecione a opção Maven/Existing Maven Projects, na próxima tela aponte para o diretório para onde foi feito o clone do projeto do git, e no final clique em Finalizar. 

- Abra o package br.com.b2w.app; 

- Clique na classe App 

- Execute o programa como se fosse um aplicativo Java, não é necessário instalar o Tomcat pois o Spring Boot já possui ele embutido. 

- Clique com o botão direito do mouse  e navegue para Run As > Java Application $ No console, Aguarde o servidor subir, enquanto isso abra o browser (IE, Firefox, Chrome). 

- Após o servidor ficar de pé, acesse o endereço: http://localhost:8080/backend-challenge/item?begindate=05-10-2016&finaldate=10-10-2016 

- O retorno são os dados consumidos da API de serviço no formato Json conforme response abaixo.

Os parâmetros begindate (data) e finaldate (data) deveram serem informados no formato dd-MM-yyyy


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

