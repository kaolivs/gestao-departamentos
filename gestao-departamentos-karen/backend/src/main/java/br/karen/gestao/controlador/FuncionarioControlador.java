package br.karen.gestao.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import br.karen.gestao.dto.FuncionarioEntradaDTO;
import br.karen.gestao.dto.FuncionarioSaidaDTO;
import br.karen.gestao.servico.FuncionarioServico;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioControlador {
    @Autowired
    private FuncionarioServico servico;
    @GetMapping
    public ResponseEntity<List<FuncionarioSaidaDTO>> listar() {
        return ResponseEntity.ok(servico.listar());
    }
    @PostMapping
    public ResponseEntity<FuncionarioSaidaDTO> criar(@Validated @RequestBody FuncionarioEntradaDTO dto) {
        return ResponseEntity.ok(servico.criar(dto));
    }
}
