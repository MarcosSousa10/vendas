package com.vendas.vendas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name="nome", length = 50)
    private String nome;
    @NotBlank
    @Column(name="email", length = 50)
    private String email;
    @Column
    private String telefone;
    @NotBlank
    @Column
    private String senha;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Usuario() {
    }
    public Usuario(Long id, @NotBlank String nome, @NotBlank String email, String telefone, @NotBlank String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", senha="
                + senha + "]";
    }

    
}
