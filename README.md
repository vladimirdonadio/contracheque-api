
# CONTRACHEQUE_API - API DA APLICACAO CONTRACHEQUE_API

Serviço reponsável por concentrar as apis que servem a aplicação cliente

# ORIENTAÇÕES DESENVOLVEDOR

### EXECUTAR PROJETO NA MAQUINA LOCAL

#### Linha de comando 1

mvn clean package quarkus:dev

#### Linha de comando 2 (executar os 3 comandos na ordem) (estes comandos dependem do projeto environment)

mvn clean package

cd ../contracheque-envirionment/; docker-compose down; docker-compose up --build -d contracheque-api; cd ../contracheque-api

mvn quarkus:remote-dev -Dquarkus.live-reload.url=http://localhost:8080 -Dquarkus.live-reload.password=123 -Ddebug=false


#### Debug

Utilizar a IDE [CodeReady Studio da RedHat baseada em Eclipse](https://developers.redhat.com/products/codeready-studio/download) com [plugin Quarkus Tools](https://quarkus.io/blog/eclipse-got-quarkused/).


# QUALIDADE DE CODIGO


mvn clean install sonar:sonar jacoco:prepare-agent test jacoco:report


Você poderá verificar seu [resultado no relatório](http://sonar.apps.rio.gov.br/dashboard?id=cariocadigapp-api-gateway).



# DOCUMENTACAO DA API

Documentação nativa via anotações e configuação no application.properties

Swagger - https://contracheque-api-dev.apps.rio.gov.br/swagger-ui/

OpenApi - https://contracheque-api-dev.apps.rio.gov.br/swagger/




# URL DA API

Desenvolvimento - https://contracheque-api-dev.apps.rio.gov.br/

Homologação - em andamento

Produção - em andamento



# DOCKER

docker build -f src/main/docker/Dockerfile.fast-jar -t registry.apps.rio.gov.br/rio/contracheque-api/api:latest .

docker push registry.apps.rio.gov.br/rio/contracheque-api/api:latest
"# contracheque_api" 
