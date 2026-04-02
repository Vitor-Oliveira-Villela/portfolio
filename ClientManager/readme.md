Client Manager - Sistema de Gerenciamento de Clientes (CRUD)

Este projeto é um sistema CRUD desenvolvido em Java para gerenciamento de clientes, utilizando PostgreSQL como banco de dados e Maven para gerenciamento de dependências.
A aplicação é executada via terminal (CMD), permitindo a interação do usuário por meio de um menu simples.

Funcionalidades

Listar clientes cadastrados
Adicionar novos clientes
Editar dados de clientes
Remover clientes

Tecnologias Utilizadas

Java
PostgreSQL
Maven
JDBC

Estrutura do Projeto

src/
 └── main/
     └── java/
         └── com/clientmanager/
             ├── database/
                 ├── DbConnection.java
                 └── DbService.java
             ├── model/
                 └── Client.java
             ├── view/
                 └── UserView.java
             └── Main.java

Configuração do Banco de Dados

    Criar banco

    Criar tabelas

Configuração da Conexão

Como Executar

Exemplo de Uso

Objetivo

Praticar conceitos de CRUD, integração com banco de dados relacional e organização de projetos Java utilizando Maven.

Melhorias Futuras

Interface gráfica (JavaFX ou Swing)
Validação de dados mais robusta
Sistema de busca
Paginação de resultados
Testes automatizados

Autor

Vitor Villela