package br.karen.gestao.dto;

public class FuncionarioSaidaDTO {
    private Long id;
    private String nome;
    private Long departamentoId;
    private String departamentoNome;
    private String departamentoSigla;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Long getDepartamentoId() { return departamentoId; }
    public void setDepartamentoId(Long departamentoId) { this.departamentoId = departamentoId; }
    public String getDepartamentoNome() { return departamentoNome; }
    public void setDepartamentoNome(String departamentoNome) { this.departamentoNome = departamentoNome; }
    public String getDepartamentoSigla() { return departamentoSigla; }
    public void setDepartamentoSigla(String departamentoSigla) { this.departamentoSigla = departamentoSigla; }
}
