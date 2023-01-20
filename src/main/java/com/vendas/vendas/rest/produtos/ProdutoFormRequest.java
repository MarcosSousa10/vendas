package com.vendas.vendas.rest.produtos;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vendas.vendas.model.Produto;

public class ProdutoFormRequest {
    private Long id;
    private String descricao;
    private String nome;
    private BigDecimal preco;
    private String sku;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate cadastro;

    public ProdutoFormRequest() {
    }
    public ProdutoFormRequest(Long id, String descricao, String nome, BigDecimal preco, String sku, LocalDate cadastro) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.sku = sku;
        this.cadastro=cadastro;
    }
    public Produto toModel(){
        return new Produto(id, nome, descricao, preco, sku);
    }
    public static ProdutoFormRequest fromModel(Produto produto){
        return new ProdutoFormRequest(produto.getId(),produto.getDescricao(),produto.getNome(),produto.getPreco(),produto.getSku(),produto.getDataCadastro());
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", nome='" + getNome() + "'" +
            ", preco='" + getPreco() + "'" +
            ", sku='" + getSku() + "'" +
            "}";
    }
    public LocalDate getCadastro() {
        return cadastro;
    }
    public void setCadastro(LocalDate cadastro) {
        this.cadastro = cadastro;
    }

}
