# ForumHub
# Forum Hub
Projeto exemplo do Challenge Forum Hub (Spring Boot, JPA, JWT)

## Requisitos
- Java 17+
- Maven

## Como rodar
1. `mvn clean package`
2. `mvn spring-boot:run` ou execute a classe `ForumHubApplication`
3. Acesse `http://localhost:8080`

Endpoints principais:
- `POST /auth/login` -> recebe email + senha e retorna token
- `POST /usuarios` -> cria usuário (sem autenticação neste exemplo)
- `GET /topicos` -> lista tópicos
- `POST /topicos` -> cria tópico (bearer token necessário)

H2 Console: `http://localhost:8080/h2-conso
