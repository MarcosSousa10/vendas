package com.vendas.vendas.rest.vendedor;

import java.time.LocalDate;

import com.vendas.vendas.model.Vendedor;

public class VendedorFormRequest {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;    
    private LocalDate cadastroVendedor;
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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
    public LocalDate getCadastroVendedor() {
        return cadastroVendedor;
    }
    public void setCadastroVendedor(LocalDate cadastroVendedor) {
        this.cadastroVendedor = cadastroVendedor;
    }
    public VendedorFormRequest(Long id, String nome, String cpf, String email, String telefone,
            LocalDate cadastroVendedor) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.cadastroVendedor = cadastroVendedor;
    }
    public VendedorFormRequest() {
    }
    public Vendedor toModel(){
        return new Vendedor(id, cpf, nome, telefone, email,cadastroVendedor);
    }
    public static VendedorFormRequest fromModel(Vendedor vendedor){
        return new VendedorFormRequest(vendedor.getId(), vendedor.getNome(),vendedor.getCPF(),vendedor.getEmail(),vendedor.getTelefone(),
        vendedor.getDataCadastroVendedor());
    }
}
