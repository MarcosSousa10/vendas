package com.vendas.vendas.rest.CadastroCusto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vendas.vendas.model.CadastroCusto;
import com.vendas.vendas.model.Login;

public class CadastroCustoFormTRequest {
    private Long Id;
    private String nome;
    private BigDecimal preco; 
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate cadastro;
    public CadastroCusto toModel(){
        return new CadastroCusto(Id, nome, preco, cadastro);
    }
    public static CadastroCustoFormTRequest fromModel(CadastroCusto produto){
        return new CadastroCustoFormTRequest(produto.getId(),produto.getNome(),produto.getPreco(),produto.getDataCadastro());
    }
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public LocalDate getCadastro() {
        return cadastro;
    }
    public void setCadastro(LocalDate cadastro) {
        this.cadastro = cadastro;
    }
    public CadastroCustoFormTRequest(Long id, String nome, BigDecimal preco, LocalDate cadastro) {
        Id = id;
        this.nome = nome;
        this.preco = preco;
        this.cadastro = cadastro;
    }
    public CadastroCustoFormTRequest() {
    }
    @Override
    public String toString() {
        return "CadastroCustoFormTRequest [Id=" + Id + ", nome=" + nome + ", preco=" + preco + ", cadastro=" + cadastro
                + "]";
    }
    
}
