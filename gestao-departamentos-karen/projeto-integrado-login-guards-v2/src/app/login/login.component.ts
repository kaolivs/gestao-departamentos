import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AutenticacaoService } from '../services/autenticacao.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {
  email = '';

  constructor(private auth: AutenticacaoService, private router: Router) {}

  ngOnInit(): void {
    if (this.auth.estaAutenticado()) this.router.navigate(['/departamentos']);
  }

  entrar() {
    if (!this.email) return;
    this.auth.entrar(this.email);
    this.router.navigate(['/departamentos']);
  }
}
