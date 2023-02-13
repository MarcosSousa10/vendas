package com.vendas.vendas.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name="nome", length = 50,)
    private String nome;
    @NotBlank
    @Column(name="email", length = 50)
    private String email;
    @Column
    private String telefone;
    @NotBlank
    @Column
    private String senha;
    
}
