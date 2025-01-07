# ForumHub - Projeto Challenge Backend

## Descrição
Projeto de API REST para um fórum de discussão, desenvolvido como parte do Challenge Backend da Alura.

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.1.5
- Spring Security
- JWT
- MySQL
- Flyway Migration
- Hibernate/JPA

## Funcionalidades
- Autenticação de usuários
- CRUD de Tópicos
- Controle de Acesso
- Validação de Dados

## Configuração

### Pré-requisitos
- Java 17
- Maven
- MySQL

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
