package br.karen.gestao.servico;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import br.karen.gestao.dominio.Departamento;
import br.karen.gestao.dto.DepartamentoEntradaDTO;
import br.karen.gestao.dto.DepartamentoSaidaDTO;
import br.karen.gestao.excecao.NegocioException;
import br.karen.gestao.excecao.RecursoNaoEncontradoException;
import br.karen.gestao.repositorio.DepartamentoRepositorio;

@Service
public class DepartamentoServico {
    @Autowired
    private DepartamentoRepositorio repositorio;
    @Transactional(readOnly = true)
    public List<DepartamentoSaidaDTO> listar() {
        return repositorio.findAll().stream().map(this::mapearSaida).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<DepartamentoSaidaDTO> listarAtivos() {
        return repositorio.findAll().stream().filter(d -> Boolean.TRUE.equals(d.getAtivo())).map(this::mapearSaida).collect(Collectors.toList());
    }
    @Transactional
    public DepartamentoSaidaDTO criar(DepartamentoEntradaDTO dto) {
        if (repositorio.existsByNomeIgnoreCase(dto.getNome())) throw new NegocioException("Departamento já existe");
        Departamento d = new Departamento();
        d.setNome(dto.getNome());
        d.setSigla(dto.getSigla());
        d.setAtivo(true);
        d = repositorio.save(d);
        return mapearSaida(d);
    }
    @Transactional
    public DepartamentoSaidaDTO atualizar(Long id, DepartamentoEntradaDTO dto) {
        Departamento d = repositorio.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Departamento não encontrado"));
        if (!d.getNome().equalsIgnoreCase(dto.getNome()) && repositorio.existsByNomeIgnoreCase(dto.getNome())) throw new NegocioException("Departamento já existe");
        d.setNome(dto.getNome());
        d.setSigla(dto.getSigla());
        return mapearSaida(d);
    }
    @Transactional
    public DepartamentoSaidaDTO inativar(Long id) {
        Departamento d = repositorio.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Departamento não encontrado"));
        d.setAtivo(false);
        return mapearSaida(d);
    }
    private DepartamentoSaidaDTO mapearSaida(Departamento d) {
        DepartamentoSaidaDTO s = new DepartamentoSaidaDTO();
        s.setId(d.getId());
        s.setNome(d.getNome());
        s.setSigla(d.getSigla());
        s.setAtivo(d.getAtivo());
        return s;
    }
}
