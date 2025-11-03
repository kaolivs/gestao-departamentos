
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from './api.service';

@Component({
  standalone: true,
  selector: 'lista-departamento',
  imports: [CommonModule],
  template: `
    <h2>Departamentos</h2>
    <table>
      <thead><tr><th>ID</th><th>Nome</th><th>Sigla</th><th>Ativo</th><th>Ações</th></tr></thead>
      <tbody>
        <tr *ngFor="let d of dados">
          <td>{{d.id}}</td><td>{{d.nome}}</td><td>{{d.sigla}}</td><td>{{d.ativo ? 'Sim' : 'Não'}}</td>
          <td><button (click)="inativar(d.id)" [disabled]="!d.ativo">Inativar</button></td>
        </tr>
      </tbody>
    </table>
  `
})
export default class ListaDepartamentoComponent implements OnInit {
  dados: any[] = [];
  constructor(private api: ApiService) {}
  ngOnInit() { this.api.listarDepartamentos().subscribe(r => this.dados = r); }
  inativar(id: number) { this.api.inativarDepartamento(id).subscribe(() => this.api.listarDepartamentos().subscribe(r => this.dados = r)); }
}
