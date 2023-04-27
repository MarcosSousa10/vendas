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
@Getter
@Setter
public class Login {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal custo;
    @Column
    private String dataCadastro;
  


}
