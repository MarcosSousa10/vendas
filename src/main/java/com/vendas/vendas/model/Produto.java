package com.vendas.vendas.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "descricao", length = 255)
    private String descricao;
    @Column(name = "preco", precision = 16, scale = 2)
    private BigDecimal preco;
    @Column(name = "custo", precision = 16, scale = 2)
    private BigDecimal custo;
    @Column
    private String sku;
    @Column
    private LocalDate dataCadastro;

    public Produto(String nome, String descricao, BigDecimal preco, BigDecimal custo, String sku,
            LocalDate dataCadastro) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.custo = custo;
        this.sku = sku;
        this.dataCadastro = dataCadastro;
    }

    public Produto(Long id, String nome, String descricao, BigDecimal preco, BigDecimal custo, String sku,
            LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.custo = custo;
        this.sku = sku;
        this.dataCadastro = dataCadastro;
    }

    @PrePersist
    public void prePersist() {
        setDataCadastro(LocalDate.now());
    }

    public Produto() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", custo="
                + custo + ", sku=" + sku + "]";
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

}
