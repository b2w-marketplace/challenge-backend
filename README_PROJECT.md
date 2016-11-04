# Desafio Backend BIT - SP

Boa noite,

Em primeiro lugar quero agradescer pela oportunidade de realizar o teste, pois foi uma forma de mostrar o meu conhecimento.

#### Desenvolvimento
```
Para criar o projeto usei o Maven 3 usando Ide Intellij;
A JDK foi Open JDK versão 8 (Java 8);
Framework de setup do projeto o Spring Boot versão 1.5;

```
#### Desing das Classes

Foram criadas as classes de Controle, Service, DTO e Classes de Test.
Prática usada para o teste foi TDD.

Fiz mais testes para a classe de Serviço, para a classe de Controller fiz 1 (confesso que gostaria de ter feito pelo menos 10 cenarios).

#### Executar o teste

```
Para fazer o buil do projeto usei o maven.
Acesse o pasta do projeto (cd ~/challenge-backend)
Use o comando:

mvn clean package (neste caso os teste serão executados para o processo de build)
mvn clean package -Dmaven.test.skip=true (para não compilar com execução dos testes)

```
Para fazer o buil do projeto usei o maven.
Acesse o pasta do projeto (cd ~/challenge-backend)
Use o comando:

mvn clean package (neste caso os teste serão executados para o processo de build)
mvn clean package -Dmaven.test.skip=true (para não compilar com execução dos testes)


#### Executar o serviço

```
curl http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016

```
