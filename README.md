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

- **h2**  
  Utilizado para desenvolvimento e testes locais, facilitando a execução do projeto sem dependências externas.

- **oracle**  
  Utilizado para simular um ambiente mais próximo de produção, com banco de dados Oracle.

A troca de ambiente é feita através do profile ativo.

---

## ▶️ Como executar o projeto

### 🔹 Executar localmente com H2

```bash
mvn spring-boot:run
