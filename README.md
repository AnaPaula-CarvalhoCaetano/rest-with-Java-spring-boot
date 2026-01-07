# REST API com Spring Boot

Este projeto é uma API REST desenvolvida com **Spring Boot**, com o objetivo de demonstrar boas práticas no desenvolvimento backend, utilizando **profiles**, integração com banco de dados e Docker como diferencial.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Maven
- H2 Database
- Oracle Database
- Docker
- OpenAPI / Swagger

---

## 🗄️ Bancos de Dados e Profiles

O projeto utiliza **Spring Profiles** para alternar entre diferentes ambientes:

- **h2 (Docker)**  
  Utilizado para desenvolvimento e testes dentro de um **container Docker**, facilitando a execução do projeto sem instalar o banco localmente.
  - Configuração: `application-h2.yaml`
  - Porta do container: 8080
  - Porta para requisições do host: 8081
  - Exemplo de URL para testar a API:
    ```
    http://localhost:8081/api/person
    ```

- **oracle (local)**  
  Utilizado para simular um ambiente próximo de produção, rodando **localmente na sua máquina**.
  - Configuração: `application-oracle.yaml`
  - Porta para requisições: 8080
  - Exemplo de URL para testar a API:
    ```
    http://localhost:8080/api/person
    ```

A troca de ambiente é feita através do **profile ativo**.

---

## ▶️ Como executar o projeto

### 🔹 Executar com H2 no Docker

1. Certifique-se de que o **Docker** está rodando.
2. Dentro da pasta do projeto, execute:

```bash
docker-compose up -d
