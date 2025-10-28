# Gestão de Departamentos e Funcionários

![Java](https://img.shields.io/badge/Java-17-007396?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?logo=springboot&logoColor=white)
![Angular](https://img.shields.io/badge/Angular-17-DD0031?logo=angular&logoColor=white)
![License](https://img.shields.io/badge/status-pronto-blue)
![Build](https://img.shields.io/badge/build-maven%20%7C%20angular%20cli-orange)

Aplicação full‑stack para **gestão de departamentos e funcionários**.  
Backend em **Spring Boot 3 (Java 17)** e frontend em **Angular 17**.

---

## ✨ Funcionalidades
- Cadastro e listagem de **Departamentos** (com `nome`, `sigla`, `ativo` e unicidade de nome).
- Ação de **inativar departamento**.
- Cadastro e listagem de **Funcionários** vinculados a um departamento **ativo**.
- **Swagger/OpenAPI** disponível para exploração dos endpoints.

---

## 📁 Estrutura do projeto
```
.
├── backend/            # API Spring Boot (Java 17)
│   ├── src/main/java/...
│   ├── src/main/resources/application.properties
│   └── README.md
├── frontend/           # App Angular 17 (standalone)
│   ├── src/
│   ├── package.json
│   └── README.md
└── README.md           # Este arquivo (capa do repositório)
```

---

## 🚀 Como executar

### Backend (API)
Pré‑requisitos: **Java 17** e **Maven 3.9+**
```bash
cd backend
mvn spring-boot:run
```
- Base URL: `http://localhost:8080`
- Swagger: `http://localhost:8080/swagger`

Banco: **H2 em memória** (dados de exemplo via `data.sql`).

### Frontend (Web)
Pré‑requisitos: **Node 20+** e **Angular CLI 17**
```bash
cd frontend
npm install
npm start
```
Acesse `http://localhost:4200`.

> Se a URL da API for diferente, ajuste em `frontend/src/app/api.service.ts` (propriedade `base`).

---

## 🔗 Endpoints principais
- **Departamentos**
  - `GET /api/departamentos`
  - `GET /api/departamentos/ativos`
  - `POST /api/departamentos`
  - `PUT /api/departamentos/{id}`
  - `PATCH /api/departamentos/{id}/inativar`
- **Funcionários**
  - `GET /api/funcionarios`
  - `POST /api/funcionarios`

Erros de negócio retornam mensagem objetiva (ex.: **409** para duplicidade de nome; bloqueio de funcionário em departamento inativo).

---

## 🧰 Stack técnica
- **Java 17**, **Spring Boot 3**, **Spring Web**, **Spring Validation**, **Spring Data JPA**
- **H2 Database** (dev), **Springdoc OpenAPI** (Swagger)
- **Angular 17** (standalone), **HttpClient**

---

## 🗂️ Commits e branches
Sugestão de mensagens: `feat:`, `fix:`, `refactor:`, `docs:`, `chore:`.  
Crie uma branch `dev` para evoluções e abra **Pull Requests** para `main`.

---

## 📸 Prints (opcionais)
Cole aqui imagens do sistema em execução:
- Lista de Departamentos
- Formulário de Novo Departamento
- Formulário de Novo Funcionário

---

## 👤 Autor
**KAREN QUEZIA DE OLIVEIRA**

---

> Dica: se este README não aparecer na capa do GitHub, garanta que ele esteja **na raiz** da branch padrão (`main`) com o nome **README.md**.
