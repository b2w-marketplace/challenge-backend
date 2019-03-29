Backend Challenge BIT - SP

Esse projeto foi construído usando uma versão simplificada da Clean Architecture (http://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html).

Utilizamos o Spring Boot como facilitador, na sua última versão disponível (2.1.3).

Para construir a aplicação, utilize o comando:

mvn clean package

Desta forma, no diretório "target" será gerado o jar "backend-challenge-0.0.1-SNAPSHOT.jar", que pode ser executado com o comando:

java -jar target\backend-challenge-0.0.1-SNAPSHOT.jar

Ou, utilizando o plugin do maven do Spring Boot, sem precisar pré construir a aplicação:

mvn spring-boot:run

 