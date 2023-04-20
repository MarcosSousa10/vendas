package com.vendas.vendas.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ItemVendaFixo {
    @ Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @ManyToOne
    @JoinColumn(name="id_venda")
    private Venda venda;
    @ManyToOne
    @JoinColumn(name="id_produto")
    private ProdutoFixo produto;
    @Column
    private Integer quantidade;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Venda getVenda() {
        return venda;
    }
    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    @Override
    public String toString() {
        return "ItemVenda [id=" + id + ", venda=" + venda + ", produto=" + produto + ", quantidade=" + quantidade + "]";
    }
    
}
