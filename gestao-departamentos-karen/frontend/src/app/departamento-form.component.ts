
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from './api.service';

@Component({
  standalone: true,
  selector: 'form-departamento',
  imports: [CommonModule, FormsModule],
  template: `
    <h2>Novo Departamento</h2>
    <form (ngSubmit)="salvar()">
      <label>Nome</label>
      <input [(ngModel)]="nome" name="nome" required />
      <label>Sigla</label>
      <input [(ngModel)]="sigla" name="sigla" required />
      <button type="submit">Salvar</button>
    </form>
    <div *ngIf="mensagem">{{mensagem}}</div>
  `
})
export default class FormDepartamentoComponent {
  nome = '';
  sigla = '';
  mensagem = '';
  constructor(private api: ApiService) {}
  salvar() {
    this.api.criarDepartamento({ nome: this.nome, sigla: this.sigla }).subscribe({
      next: () => this.mensagem = 'Criado',
      error: e => this.mensagem = e?.error?.erro || 'Erro'
    });
  }
}
