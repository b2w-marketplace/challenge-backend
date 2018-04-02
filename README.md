# Desafio Backend BIT - SP

Desenvolver um serviço rest que consulta a API de Item [(link da API)](http://www.mocky.io/v2/5817803a1000007d01cc7fc9) e com base no resultado realiza um filtro pela data de acordo com os parametros enviados na requisição HTTP.

## Tecnologias Utilizadas
- Java 8
- Spring Boot 2.0.0
- Maven
- Spring Actuator

## Como rodar
Para rodar o projeto é necessário apenas rodar os seguintes comandos no diretorio do projeto:
- mvn clean install (baixar as dependencias e rodar os testes)
- mvn spring-boot:run (rodar o projeto)

Feitos os passos acima, para saber se está tudo ok, fazer a seguinte requisição:
```
GET http://localhost:9001/actuator/health
```

Caso retorno o "status" com valor "UP", quer dizer que está tudo certo.

## Chamando a aplicação
Para chamar a aplicação é necessário fazer uma requisição como o exemplo abaixo: 
```
GET http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=12-10-2016
```
