package br.karen.gestao.repositorio;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.karen.gestao.dominio.Departamento;

public interface DepartamentoRepositorio extends JpaRepository<Departamento, Long> {
    boolean existsByNomeIgnoreCase(String nome);
    Optional<Departamento> findByIdAndAtivoTrue(Long id);
}
