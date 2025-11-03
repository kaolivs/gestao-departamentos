
import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  template: `
    <h1>Gestão de Departamentos e Funcionários</h1>
    <nav class="toolbar">
      <a routerLink="/">Departamentos</a>
      <a routerLink="/departamentos/novo">Novo Departamento</a>
      <a routerLink="/funcionarios/novo">Novo Funcionário</a>
    </nav>
    <router-outlet />
  `
})
export default class AppComponent {}
