
# Gestão de Funcionários e Departamentos — Login e Guards

## Visão Geral
Projeto Angular com tela de Login, cabeçalho fixo, rotas protegidas por guard de autenticação e confirmação de saída quando houver alterações não salvas em formulários.

## Instruções de Execução
1. Instale as dependências:
   ```bash
   npm install
   ```
2. Rode a aplicação:
   ```bash
   npm start
   # ou
   ng serve
   ```
3. Acesse no navegador:
   - http://localhost:4200/login

## Fluxo de Autenticação
- A tela de **Login** salva um `token` e o `email` no `localStorage` após o envio do formulário.
- Usuários sem `token` são redirecionados para `/login` ao tentar acessar rotas privadas.
- O **Cabeçalho** exibe o e-mail autenticado e possui botão **Sair**, que remove o `token` e volta para `/login`.

Arquivos relevantes:
- `src/app/services/autenticacao.service.ts`
- `src/app/login/login.component.ts` e `login.component.html`
- `src/app/header/header.component.ts` e `header.component.html`

## Guards Utilizados
### Guard de Autenticação
- Arquivo: `src/app/guards/auth.guard.ts`
- Bloqueia acesso às rotas privadas quando não há `token` no `localStorage`.
- Aplicado às rotas dentro de `AreaPrivadaComponent` em `src/app/app.routes.ts`.

### Guard de Alterações não Salvas
- Arquivo: `src/app/guards/unsaved-changes.guard.ts`
- Exibe confirmação ao sair de um formulário com alterações pendentes.
- Aplicado em:
  - `/departamentos/novo`
  - `/funcionarios/novo`

Para funcionar, cada formulário deve expor o método:
```ts
temAlteracoesNaoSalvas(): boolean { return this.form?.dirty === true; }
```

## Rotas
- Público:
  - `/login`
- Privado (protegidas por `authGuard`):
  - `/departamentos`, `/departamentos/novo`, `/departamentos/:id`
  - `/funcionarios`, `/funcionarios/novo`, `/funcionarios/:id`

## Estrutura Relacionada
- `src/app/area-privada.component.ts` renderiza o `<app-header>` e o `<router-outlet>`.
- `src/app/app.routes.ts` centraliza as rotas e aplicação dos guards.
- `src/app/app.config.ts` provê o roteamento da aplicação.

## Observações
- A autenticação é didática (token mock em `localStorage`).
- Ajuste os formulários para o método `temAlteracoesNaoSalvas()` quando aplicável.
