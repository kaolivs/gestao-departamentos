
import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter, Routes } from '@angular/router';
import { importProvidersFrom } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app/app.component';
import { ListaDepartamentoComponent } from './app/departamento-lista.component';
import { FormDepartamentoComponent } from './app/departamento-form.component';
import { FormFuncionarioComponent } from './app/funcionario-form.component';

const rotas: Routes = [
  { path: '', component: ListaDepartamentoComponent },
  { path: 'departamentos/novo', component: FormDepartamentoComponent },
  { path: 'funcionarios/novo', component: FormFuncionarioComponent }
];

bootstrapApplication(AppComponent, {
  providers: [provideRouter(rotas), importProvidersFrom(HttpClientModule)]
});
