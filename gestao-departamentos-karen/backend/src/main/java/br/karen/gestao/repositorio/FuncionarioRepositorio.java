package br.karen.gestao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.karen.gestao.dominio.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {
}
