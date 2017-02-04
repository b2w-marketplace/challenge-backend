# Desafio Backend BIT - SP

Desenvolver um serviço rest que consulta a API de Item (link da API) e com base no resultado realiza um filtro pela data de acordo com os parametros enviados na requisição HTTP.

## Pré requisitos

Maven versão >= 3.0
Java versão 8.0

## Procedimentos

Uma vez efetuado o download do projeto deve-se executar o seguinte comando no terminal/console:

mvn clean install spring-boot:run

OBS: Adicionar o seguinte parâmetro caso não se deseja executar os testes de unidade
-DskipTests=true

Finalizado o processo de build/deploy, abrir o navegador de preferência e acessar o seguinte endereço:

http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016

Para melhor visualização sugere-se colar o conteúdo de retorno no seguinte endereço web:

http://jsonviewer.stack.hu/

Quando o conteúdo estiver disponível, selecionar o botão "Format" e/ou acessar a aba "Viewer"

## Eclipse

Para realizar a importação do projeto na IDE eclipse deve-se, primeiro, executar o seguinte comando no diretório onde se encontra o projeto:

mvn eclipse:clean eclipse:eclipse