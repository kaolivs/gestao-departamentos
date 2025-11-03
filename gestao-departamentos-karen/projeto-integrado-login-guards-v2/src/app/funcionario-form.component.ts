
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from './api.service';

@Component({
  standalone: true,
  selector: 'form-funcionario',
  imports: [CommonModule, FormsModule],
  template: `
    <h2>Novo Funcionário</h2>
    <form (ngSubmit)="salvar()">
      <label>Nome</label>
      <input [(ngModel)]="nome" name="nome" required />
      <label>Departamento</label>
      <select [(ngModel)]="departamentoId" name="departamentoId" required>
        <option *ngFor="let d of departamentos" [value]="d.id">{{d.sigla}} - {{d.nome}}</option>
      </select>
      <button type="submit">Salvar</button>
    </form>
    <div *ngIf="mensagem">{{mensagem}}</div>
  `
})
export default class FormFuncionarioComponent implements OnInit {
  nome = '';
  departamentoId: number | null = null;
  departamentos: any[] = [];
  mensagem = '';
  constructor(private api: ApiService) {}
  ngOnInit() { this.api.listarDepartamentosAtivos().subscribe(r => this.departamentos = r); }
  salvar() {
    this.api.criarFuncionario({ nome: this.nome, departamentoId: this.departamentoId }).subscribe({
      next: () => this.mensagem = 'Criado',
      error: e => this.mensagem = e?.error?.erro || 'Erro'
    });
  }
}
