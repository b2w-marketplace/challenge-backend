# Backend Challenge BIT - SP

1) Para iniciar a aplicação, faça um clone dessa branch
    ```
    - git clone --branch massinha-dev https://github.com/massinha/challenge-backend.git
    ```
2) Na pasta 'challenge', execute o comando maven
    ```
    - mvn clean install
    ```
3) Navegue até a pasta target
    ```
    cd target/
    ```
4) Execute o arquivo .jar 'Challenge-1.0-SNAPSHOT.jar'
    ```
    java -jar Challenge-1.0-SNAPSHOT.jar
    ```

    Feito isso, o serviço estará disponível no endereço 'http://localhost:8080/challenge-backend/item'

    A documentação pode ser encontrada em 'http://localhost:8080/swagger-ui.html'


    ```
     GET http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016
     ```