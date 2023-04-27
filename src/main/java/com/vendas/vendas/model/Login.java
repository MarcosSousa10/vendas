package com.vendas.vendas.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dataCadastro;
    
    @Column
    private BigDecimal custo;
    public BigDecimal getCusto() {
        return custo;
    }
    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }
    public Long getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Long dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    @Override
    public String toString() {
        return "Login [custo=" + custo + ", dataCadastro=" + dataCadastro + "]";
    }
    public Login() {
    }
    public Login(BigDecimal custo, Long dataCadastro) {
        this.custo = custo;
        this.dataCadastro = dataCadastro;
    }
  


}
