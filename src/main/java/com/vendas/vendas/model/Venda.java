package com.vendas.vendas.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;

@Entity

public class Venda {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;
   @ManyToOne
   @JoinColumn(name="id_cliente")
   private Cliente cliente;
   @Enumerated(EnumType.STRING)
   @Column(name="forma_pagamento")
   private FormaPagamento FormaPagamento;
   @OneToMany(mappedBy = "venda")
   private List<ItemVenda> itens;
   @Column
   private BigDecimal total;
   @Column(name = "data-cadastro")
   private LocalDateTime dataCadastro;
   @PrePersist
   public void prePersist(){
    setDataCadastro(LocalDateTime.now());
   }
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public Cliente getCliente() {
    return cliente;
}
public void setCliente(Cliente cliente) {
    this.cliente = cliente;
}
public FormaPagamento getFormaPagamento() {
    return FormaPagamento;
}
public void setFormaPagamento(FormaPagamento formaPagamento) {
    FormaPagamento = formaPagamento;
}
public List<ItemVenda> getItens() {
    return itens;
}
public void setItens(List<ItemVenda> itens) {
    this.itens = itens;
}
public BigDecimal getTotal() {
    return total;
}
public void setTotal(BigDecimal total) {
    this.total = total;
}
@Override
public String toString() {
    return "Venda [id=" + id + ", cliente=" + cliente + ", FormaPagamento=" + FormaPagamento + ", itens=" + itens
            + ", total=" + total + "]";
}
public LocalDateTime getDataCadastro() {
    return dataCadastro;
}
public void setDataCadastro(LocalDateTime dataCadastro) {
    this.dataCadastro = dataCadastro;
} 


}
