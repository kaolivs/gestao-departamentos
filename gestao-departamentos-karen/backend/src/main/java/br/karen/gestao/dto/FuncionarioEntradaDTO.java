package br.karen.gestao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FuncionarioEntradaDTO {
    @NotBlank
    private String nome;
    @NotNull
    private Long departamentoId;
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Long getDepartamentoId() { return departamentoId; }
    public void setDepartamentoId(Long departamentoId) { this.departamentoId = departamentoId; }
}
