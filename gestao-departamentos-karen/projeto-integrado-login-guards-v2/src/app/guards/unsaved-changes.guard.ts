import { CanDeactivateFn } from '@angular/router';

export type PodeSair = { temAlteracoesNaoSalvas: () => boolean };

export const unsavedChangesGuard: CanDeactivateFn<PodeSair> = (componente) => {
  if (componente && typeof componente.temAlteracoesNaoSalvas === 'function' && componente.temAlteracoesNaoSalvas()) {
    return confirm('Há alterações não salvas. Deseja sair?');
  }
  return true;
};
