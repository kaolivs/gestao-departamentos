package br.karen.gestao.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import br.karen.gestao.dto.DepartamentoEntradaDTO;
import br.karen.gestao.dto.DepartamentoSaidaDTO;
import br.karen.gestao.servico.DepartamentoServico;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoControlador {
    @Autowired
    private DepartamentoServico servico;
    @GetMapping
    public ResponseEntity<List<DepartamentoSaidaDTO>> listar() {
        return ResponseEntity.ok(servico.listar());
    }
    @GetMapping("/ativos")
    public ResponseEntity<List<DepartamentoSaidaDTO>> listarAtivos() {
        return ResponseEntity.ok(servico.listarAtivos());
    }
    @PostMapping
    public ResponseEntity<DepartamentoSaidaDTO> criar(@Validated @RequestBody DepartamentoEntradaDTO dto) {
        return ResponseEntity.ok(servico.criar(dto));
    }
    @PutMapping("/<built-in function id>")
    public ResponseEntity<DepartamentoSaidaDTO> atualizar(@PathVariable Long id, @Validated @RequestBody DepartamentoEntradaDTO dto) {
        return ResponseEntity.ok(servico.atualizar(id, dto));
    }
    @PatchMapping("/<built-in function id>/inativar")
    public ResponseEntity<DepartamentoSaidaDTO> inativar(@PathVariable Long id) {
        return ResponseEntity.ok(servico.inativar(id));
    }
}
