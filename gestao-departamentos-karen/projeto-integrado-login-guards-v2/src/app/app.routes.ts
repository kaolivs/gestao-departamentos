import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { authGuard } from './guards/auth.guard';
import { unsavedChangesGuard } from './guards/unsaved-changes.guard';
import { AreaPrivadaComponent } from './area-privada.component';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  {
    path: '',
    component: AreaPrivadaComponent,
    canActivate: [authGuard],
    children: [
    ]
  },
  { path: '**', redirectTo: 'login' }
];
