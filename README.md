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

O projeto utiliza **Spring Profiles** para alternar entre diferentes ambientes de execução.

### 🔹 h2 (Docker)

Utilizado para desenvolvimento e testes, com **aplicação e banco de dados rodando em containers Docker**.
Esse modo permite executar todo o projeto sem dependências instaladas localmente.

- Configuração: `application-h2.yaml`
- Aplicação Spring Boot: container Docker
- Banco de dados: H2 (container Docker)
- Porta exposta no host: **8081**

[Acesso à API](http://localhost:8081/api/person)


---

### 🔹 oracle (local)

Utilizado para simular um ambiente próximo de produção, com **aplicação e banco Oracle rodando localmente**.

- Configuração: `application-oracle.yaml`
- Aplicação Spring Boot: local
- Banco de dados: Oracle (local)
- Porta da aplicação: **8080**

[Acesso à API](http://localhost:8080/api/person)





A troca de ambiente é feita através do **profile ativo do Spring**.

---

## 🔍 Observabilidade

Este projeto implementa **observabilidade completa**, cobrindo métricas, logs e tracing distribuído.





### ⚙️ Observabilidade via Docker

Todos os serviços de observabilidade (Prometheus, Grafana, Zipkin e Kibana/Elasticsearch) rodam em **containers Docker**.
Não é necessário instalar nada localmente, basta executar o Docker Compose que os containers serão iniciados automaticamente.

- Para iniciar tudo:
```bash
  docker-compose -f docker-observability/docker-compose.yml up -d
```

Depois, acesse cada serviço:

Prometheus: http://localhost:9090

Grafana: http://localhost:3000

Zipkin: http://localhost:9411/zipkin/

Kibana: http://localhost:5601

### 📊 Métricas

As métricas são expostas via **Spring Boot Actuator** e **Micrometer**, coletadas pelo **Prometheus** e visualizadas no **Grafana**.

- Actuator: 

[http://localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus)

- Prometheus:

[http://localhost:9090](http://localhost:9090)

- Grafana:

[http://localhost:3000](http://localhost:3000)

---

### 🧵 Tracing Distribuído

O tracing distribuído é realizado com **Micrometer Tracing** e **Zipkin**, permitindo acompanhar
o tempo de execução das requisições HTTP.

- Zipkin:

[http://localhost:9411/zipkin/](http://localhost:9411/zipkin/)

---

### 📝 Logs

Os logs da aplicação são estruturados e enviados ao **Logstash**, armazenados no **Elasticsearch**
e visualizados através do **Kibana**.

- Kibana:

[http://localhost:5601](http://localhost:5601)

---

## ▶️ Como executar o projeto (H2 + Docker)

1. Certifique-se de que o **Docker** está rodando.
2. Dentro da pasta do projeto, execute:



```bash
  docker-compose up -d
```

