# Teste Dasa

Esse projeto ilustra a estrutura gerada através da utilização do SpringBoot, banco de dados e teste unitários utilizando o JDK11.

## Começando

Para executar o projeto, será necessário instalar os seguintes programas:

- [JDK 10: Necessário para executar o projeto Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)
- [Maven 3.8.1: Necessário para realizar o build do projeto Java](https://downloads.apache.org/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.zip)
- [Eclipse: Para desenvolvimento do projeto](http://www.eclipse.org/downloads/packages/release/2021-06/r/eclipse-ide-enterprise-java-and-web-developers)
- [Docker: Para servir de container da aplicação](https://download.docker.com/win/beta/InstallDocker.msi)

## Desenvolvimento

Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

```shell
cd "diretorio de sua preferencia"
git clone https://github.com/Aledrao/testeDasa

### Construção

Para construir o projeto com o Maven, executar os comando abaixo:

```shell
mvn clean install
```

O comando irá baixar todas as dependências do projeto e criar um diretório *target* com os artefatos construídos, que incluem o arquivo jar do projeto. Além disso, serão executados os testes unitários, e se algum falhar, o Maven exibirá essa informação no console.

## Features

O projeto usado como teste de desenvolvimento de um projeto Java usando o Maven, com Spring Boot, banco de dados e testes unitários. Ele também demonstra de forma prática o teste de desenvolvimento para a empresa Dasa.

## Configuração

Para executar o projeto, é necessário utilizar o Eclipse, para que o mesmo identifique as dependências necessárias para a execução no repositório .m2 do Maven. Uma vez importado o projeto, será criado um arquivo *.classpath* que irá informar qual a classe principal para a execução.

## Banco de dados

Para visualizar os dados no banco de dados, basta executar o projeto e acessar o [Console do H2](http://localhost:8080/h2) e preencher

```
JDBC URL: jdbc:h2:file:../testeDasa/src/main/resources/database/teste_dasa
User Name: sa
Os demais campos não dever ser alterados
```

## Testes

Para rodar os testes, utilize o comando abaixo:

```
mvn test
```

## Criando executável .Jar

Para rodar os testes, utilize o comando abaixo:

```
1.Execute o comando: mvn clean package
2.Dentro do diretório target, haverão dois arquivos JAR.
3.Para executar o JAR siga o comando abaixo.
java -jar target/testeDasa-0.0.1-SNAPSHOT.jar
```

## Executar com Docker
Para executar a aplicação através do Docker, rode os comandos abaixo:
```shell
cd "diretorio do projeto"
pwd /home/alexSouza/projects/testeDasa
ls -lsah
sudo docker build -t spring-boot:1.0 .
```

## Acessar documentação dos endpoints
Com o projeto em execução, acesse a URL http://localhost:8080/swagger-ui.html

## Licença

Não se aplica.
