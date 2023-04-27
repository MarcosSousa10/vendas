package com.vendas.vendas.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
@Entity
public class CadastroCusto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private BigDecimal preco; 
    private LocalDate dataCadastro;
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
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    @PrePersist
    public void prePersist() {
        setDataCadastro(LocalDate.now());
    }
    public CadastroCusto() {
    }
    public CadastroCusto(Long id, String nome, BigDecimal preco, LocalDate dataCadastro) {
        Id = id;
        this.nome = nome;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
    }
    @Override
    public String toString() {
        return "CadastroCusto [Id=" + Id + ", nome=" + nome + ", preco=" + preco + "]";
    } 
    
}
