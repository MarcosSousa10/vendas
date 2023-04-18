package com.vendas.vendas.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProdutoFixo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "nome", length=100)
    private String nome;
    @Column(name="descricao", length=255)
    private String descricao;
    @Column(name="preco", precision= 16, scale=2)
    private BigDecimal preco;
    @Column
    private String sku;
    @Column
    private LocalDate dataCadastro;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    @Override
    public String toString() {
        return "ProdutoFixo [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", sku="
                + sku + ", dataCadastro=" + dataCadastro + "]";
    }
    public ProdutoFixo(Long id, String nome, String descricao, BigDecimal preco, String sku, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.sku = sku;
        this.dataCadastro = dataCadastro;
    }
    public ProdutoFixo() {
    }

    
}
