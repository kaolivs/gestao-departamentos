Gestão de Departamentos e Funcionários

Aplicação full‑stack para gestão de departamentos e funcionários.
Backend em Spring Boot 3 (Java 17) e frontend em Angular 17.

✨ Funcionalidades
Cadastro e listagem de Departamentos (com nome, sigla, ativo e unicidade de nome).
Ação de inativar departamento.
Cadastro e listagem de Funcionários vinculados a um departamento ativo.
Swagger/OpenAPI disponível para exploração dos endpoints.

🚀 Como executar
Backend (API)
Pré‑requisitos: Java 17 e Maven 3.9+

cd backend
mvn spring-boot:run
Base URL: http://localhost:8080
Swagger: http://localhost:8080/swagger
Banco: H2 em memória (dados de exemplo via data.sql).

Frontend (Web)
Pré‑requisitos: Node 20+ e Angular CLI 17

cd frontend
npm install
npm start
Acesse http://localhost:4200.
