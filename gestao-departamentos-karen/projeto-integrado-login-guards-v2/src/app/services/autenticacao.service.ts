import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AutenticacaoService {
  private chaveToken = 'token';
  private chaveEmail = 'email';

  entrar(email: string) {
    localStorage.setItem(this.chaveToken, 'token-mock');
    localStorage.setItem(this.chaveEmail, email);
  }

  sair() {
    localStorage.removeItem(this.chaveToken);
    localStorage.removeItem(this.chaveEmail);
  }

  estaAutenticado(): boolean {
    return !!localStorage.getItem(this.chaveToken);
  }

  obterEmail(): string | null {
    return localStorage.getItem(this.chaveEmail);
  }
}
