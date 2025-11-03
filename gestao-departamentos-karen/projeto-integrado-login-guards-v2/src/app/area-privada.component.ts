import { Component } from '@angular/core';
import { CabecalhoComponent } from './header/header.component';

@Component({
  selector: 'app-area-privada',
  standalone: true,
  imports: [CabecalhoComponent],
  template: `<app-header></app-header><router-outlet></router-outlet>`
})
export class AreaPrivadaComponent {}
