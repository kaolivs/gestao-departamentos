import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { AutenticacaoService } from '../services/autenticacao.service';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './header.component.html'
})
export class CabecalhoComponent {
  constructor(private auth: AutenticacaoService, private router: Router) {}

  get email() {
    return this.auth.obterEmail();
  }

  sair() {
    this.auth.sair();
    this.router.navigate(['/login']);
  }
}
