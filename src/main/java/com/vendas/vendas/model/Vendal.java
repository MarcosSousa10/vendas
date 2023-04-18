package com.vendas.vendas.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
@Entity
public class Vendal {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valorVenda;
    private BigDecimal valorCusto;
    private BigDecimal lucro;
        // getters e setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getValorVenda() {
        return valorVenda;
    }
    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }
    public BigDecimal getValorCusto() {
        return valorCusto;
    }
    public void setValorCusto(BigDecimal valorCusto) {
        this.valorCusto = valorCusto;
    }
    public BigDecimal getLucro() {
        return lucro;
    }
    public void setLucro(BigDecimal lucro) {
        this.lucro = lucro;
    }
    @Override
    public String toString() {
        return "Vendal [id=" + id + ", valorVenda=" + valorVenda + ", valorCusto=" + valorCusto + ", lucro=" + lucro
                + "]";
    }
    
    

}

