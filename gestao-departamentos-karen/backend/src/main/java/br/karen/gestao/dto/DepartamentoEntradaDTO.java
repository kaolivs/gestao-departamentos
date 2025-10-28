package br.karen.gestao.dto;

import jakarta.validation.constraints.NotBlank;

public class DepartamentoEntradaDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String sigla;
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }
}
