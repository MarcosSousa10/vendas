package com.vendas.vendas.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "cpf", length = 20)
    private String cpf;

    @Column
    private String telefone;

    @Column
    private String email;

    @Column(name="data_cadastro_vendedor")
    private LocalDate dataCadastroVendedor;
    
    @PrePersist
    public void prePersist(){
        setDataCadastroVendedor(LocalDate.now());
    }
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

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastroVendedor() {
        return dataCadastroVendedor;
    }

    public void setDataCadastroVendedor(LocalDate dataCadastroVendedor) {
        this.dataCadastroVendedor = dataCadastroVendedor;
    }

    public Vendedor(Long id, String nome, String cpf, String telefone, String email, LocalDate dataCadastroVendedor) {
        this.id = id;
        this.nome = nome;
        cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastroVendedor = dataCadastroVendedor;
    }

    public Vendedor() {
    }

    @Override
    public String toString() {
        return "Vendedor [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email
                + ", dataCadastroVendedor=" + dataCadastroVendedor + "]";
    }
    
    
}
