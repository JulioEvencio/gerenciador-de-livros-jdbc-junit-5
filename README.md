# Gerenciador de Livros - JDBC - Junit 5
## Objetivo
Apenas um projeto para praticar testes com o **Junit 5** e conexão com o banco de dados via **JDBC**

## Ferramentas
- :pushpin: **Java 11**
- :pushpin: **Maven**
- :pushpin: **Eclipse**
- :pushpin: **MySQL 8**
- :pushpin: **Junit 5**

## Repositório
### Clone
```
git clone https://github.com/JulioEvencio/gerenciador-de-livros-jdbc-junit-5.git
```
## Observações
## Conexão com o banco
- Para este programa rodar, é necessário uma conexão com algum banco de dados. O padrão é o **MySQL**, mas isso pode ser alterado no **pom.xml**
- A classe **ConnectionFactory.java**, do pacote **gerenciador.repository**, é a responsável por criar a conexão com o banco de dados. Para adaptar a conexão com o banco de dados basta alterar a **url**, **user** e **password**

## Banco de dados
É necessário um banco de dados com o nome **gerenciador_de_livros**, mas isso pode ser alterado na **url** da classe **ConnectionFactory.java**

A seguinte imagem representa a tabela do **livro**:


![Gerenciador de Livros](https://user-images.githubusercontent.com/65574850/171516686-bcf7948c-4cbf-4332-96be-2933ef674847.png)
