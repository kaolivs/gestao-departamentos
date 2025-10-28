
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ApiService {
  base = 'http://localhost:8080/api';
  constructor(private http: HttpClient) {}
  listarDepartamentos(): Observable<any[]> { return this.http.get<any[]>(`${this.base}/departamentos`); }
  listarDepartamentosAtivos(): Observable<any[]> { return this.http.get<any[]>(`${this.base}/departamentos/ativos`); }
  criarDepartamento(body: any): Observable<any> { return this.http.post<any>(`${this.base}/departamentos`, body); }
  atualizarDepartamento(id: number, body: any): Observable<any> { return this.http.put<any>(`${this.base}/departamentos/${id}`, body); }
  inativarDepartamento(id: number): Observable<any> { return this.http.patch<any>(`${this.base}/departamentos/${id}/inativar`, {}); }
  listarFuncionarios(): Observable<any[]> { return this.http.get<any[]>(`${this.base}/funcionarios`); }
  criarFuncionario(body: any): Observable<any> { return this.http.post<any>(`${this.base}/funcionarios`, body); }
}
