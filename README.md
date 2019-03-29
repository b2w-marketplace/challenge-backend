# Backend Challenge BIT - SP
Paulo Henrique de Siqueira
paulohenriqu@hotmail.com
https://www.linkedin.com/in/paulohenriquesiqueira/

# Task 1
* Para rodar a solução é necessário que o computador tenha instalado:
    * Java JDK 8 ou superior (https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
    * Maven (https://maven.apache.org/install.html)
 
* Clone o repositório
* Vá para a pasta taskone
* rode o comando: 
```
mvn spring-boot:run
```
* A aplicação estará disponível na porta 8080 do localhost
* Faça a requisição para o endpoint http://localhost:8080/challenge-backend/item passando como query params begindate e finaldate no formato dd-MM-yyyy:
```
GET http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016
```

# Task 2
A query sql está no arquivo answer.sql na pasta task2