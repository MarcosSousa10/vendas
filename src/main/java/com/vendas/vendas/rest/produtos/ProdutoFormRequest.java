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
    private BigDecimal custo;
    private String sku;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate cadastro;

    public ProdutoFormRequest() {
    }
    public ProdutoFormRequest(Long id, String descricao, String nome, BigDecimal preco,BigDecimal custo, String sku, LocalDate cadastro) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.custo = custo;
        this.sku = sku;
        this.cadastro=cadastro;
    }
    public Produto toModel(){
        return new Produto(id, nome, descricao, preco, custo, sku, cadastro);
    }
    public static ProdutoFormRequest fromModel(Produto produto){
        return new ProdutoFormRequest(produto.getId(),produto.getDescricao(),produto.getNome(),produto.getPreco(),produto.getCusto(),produto.getSku(),produto.getDataCadastro());
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

    public BigDecimal getCusto() {
        return custo;
    }
    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }
    public void setId(Long id) {
        this.id = id;
    }

   
    @Override
    public String toString() {
        return "ProdutoFormRequest [id=" + id + ", descricao=" + descricao + ", nome=" + nome + ", preco=" + preco
                + ", custo=" + custo + ", sku=" + sku + "]";
    }
    public LocalDate getCadastro() {
        return cadastro;
    }
    public void setCadastro(LocalDate cadastro) {
        this.cadastro = cadastro;
    }

}
