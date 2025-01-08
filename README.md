![Badge-Spring](https://github.com/user-attachments/assets/e859a172-50b9-4c7c-a75f-0ec13caf8522)

# ForumHub - API de Gerenciamento de Tópicos de Fórum

## Descrição do Projeto

ForumHub é uma aplicação backend projetada para gerenciar tópicos de fórum de forma eficiente e segura. A API permite que usuários realizem operações completas de criação, listagem, detalhamento, atualização e exclusão de tópicos, com um sistema de autenticação e controle de acesso.

## Contexto do Desenvolvimento

O projeto foi concebido para atender aos requisitos de um desafio de programação, com o objetivo de demonstrar habilidades em desenvolvimento de API REST utilizando Java e Spring Boot. A solução implementa princípios de programação orientada a objetos, boas práticas de desenvolvimento e padrões de arquitetura de software.

## Funcionalidades Principais

- Autenticação de usuários com token JWT
- Criação de novos tópicos
- Listagem de tópicos existentes
- Detalhamento individual de tópicos
- Atualização de informações de tópicos
- Exclusão de tópicos
- Controle de acesso baseado em roles de usuário

## Modelo de Dados

A aplicação trabalha com as seguintes entidades principais:
- Usuário: Representa os participantes do fórum
- Tópico: Registra as discussões criadas
- Curso: Categoriza os tópicos por área de conhecimento

## Tecnologias e Ferramentas

Tecnologias Core:
- Linguagem: Java 17
- Framework: Spring Boot
- Gerenciamento de Dependências: Maven

Módulos Spring:
- Spring Web
- Spring Security
- Spring Data JPA
- Spring Validation

Banco de Dados:
- MySQL
- Flyway para versionamento de schema

Segurança:
- Autenticação JWT
- Criptografia BCrypt
- Controle de acesso baseado em roles

## Extensibilidade

A arquitetura permite futuras extensões como:
- Adição de novos tipos de usuário
- Implementação de novos filtros e consultas
- Integração com outros sistemas

## Instalação e Configuração

Pré-requisitos:
- JDK 17
- Maven
- MySQL

Passos de instalação detalhados serão fornecidos na documentação do projeto.

### Passos de Instalação
1. Clone o repositório
2. Configure o banco de dados no `application.properties`
3. Execute as migrations
4. Rode a aplicação

### Variáveis de Ambiente
- `JWT_SECRET`: Chave secreta para geração de tokens
- `DB_URL`: URL do banco de dados
- `DB_USERNAME`: Usuário do banco
- `DB_PASSWORD`: Senha do banco

## Endpoints
- `POST /login`: Autenticação
- `POST /topicos`: Criar tópico
- `GET /topicos`: Listar tópicos
- `PUT /topicos/{id}`: Atualizar tópico
- `DELETE /topicos/{id}`: Excluir tópico

## Demonstração dos testes de endpoints


https://github.com/user-attachments/assets/bddba344-7b08-4038-a00e-520febae199e


## Autor
Elineison Inacio

LinkedIn: https://www.linkedin.com/in/elineison-inacio-de-sousa/
