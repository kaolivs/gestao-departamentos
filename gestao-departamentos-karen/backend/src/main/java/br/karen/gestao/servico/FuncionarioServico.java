package br.karen.gestao.servico;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.karen.gestao.dominio.Departamento;
import br.karen.gestao.dominio.Funcionario;
import br.karen.gestao.dto.FuncionarioEntradaDTO;
import br.karen.gestao.dto.FuncionarioSaidaDTO;
import br.karen.gestao.excecao.NegocioException;
import br.karen.gestao.excecao.RecursoNaoEncontradoException;
import br.karen.gestao.repositorio.DepartamentoRepositorio;
import br.karen.gestao.repositorio.FuncionarioRepositorio;

@Service
public class FuncionarioServico {
    @Autowired
    private FuncionarioRepositorio repositorio;
    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;
    @Transactional(readOnly = true)
    public List<FuncionarioSaidaDTO> listar() {
        return repositorio.findAll().stream().map(this::mapearSaida).collect(Collectors.toList());
    }
    @Transactional
    public FuncionarioSaidaDTO criar(FuncionarioEntradaDTO dto) {
        Departamento dep = departamentoRepositorio.findById(dto.getDepartamentoId()).orElseThrow(() -> new RecursoNaoEncontradoException("Departamento não encontrado"));
        if (Boolean.FALSE.equals(dep.getAtivo())) throw new NegocioException("Departamento inativo");
        Funcionario f = new Funcionario();
        f.setNome(dto.getNome());
        f.setDepartamento(dep);
        f = repositorio.save(f);
        return mapearSaida(f);
    }
    private FuncionarioSaidaDTO mapearSaida(Funcionario f) {
        FuncionarioSaidaDTO s = new FuncionarioSaidaDTO();
        s.setId(f.getId());
        s.setNome(f.getNome());
        if (f.getDepartamento() != null) {
            s.setDepartamentoId(f.getDepartamento().getId());
            s.setDepartamentoNome(f.getDepartamento().getNome());
            s.setDepartamentoSigla(f.getDepartamento().getSigla());
        }
        return s;
    }
}
