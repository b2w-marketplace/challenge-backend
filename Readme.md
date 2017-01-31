# Challenge Backend

Para executar siga os seguintes passos:

sh
$ git clone
$ cd challenge-backend
$ mvn clean install 

$ Projeto foi desenvolvido com Spring Boot e Java 8,
$ após executar o maven, siga os seguintes passos:

$ Dentro do Eclipse abra o package com.sistema.mvc.application;
$ Clique na classe Application 
$ Execute o programa como se fosse um aplicativo J2SE, isso mesmo não precisa
instalar o Tomcat pois o Spring Boot já tem ele embutido.
$ Botão direito do mouse Run As > Java Application
$ Aguardem o servidor subir, enquanto isso abra o browser (IE, Firefox, Chrome) 
 de sua preferência.
$ Acesse com o endereço: http://localhost:8080/chalenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016
$ O retorno é dados consumidos da API de serviço no formato Json.
$ Fim

Os parâmetros begindate (data) e finaldate (data) deveram serem informados no formato dd-MM-yyyy