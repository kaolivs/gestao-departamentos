# Backend

## Requisitos
- Java 17
- Maven 3.9+

## Como executar
```bash
mvn spring-boot:run
```

A API sobe em `http://localhost:8080`. Acesse o Swagger em `/swagger`.

## Endpoints
- GET `/api/departamentos`
- GET `/api/departamentos/ativos`
- POST `/api/departamentos`
- PUT `/api/departamentos/{id}`
- PATCH `/api/departamentos/{id}/inativar`
- GET `/api/funcionarios`
- POST `/api/funcionarios`
