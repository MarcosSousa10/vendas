package com.vendas.vendas.rest.Usuario;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vendas.vendas.model.Usuario;

public class UsuarioFormRequest {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String senha;

    @JsonFormat(pattern =  "dd/MM/yyyy")
    private LocalDate cadastro;

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

    public LocalDate getCadastro() {
        return cadastro;
    }

    public void setCadastro(LocalDate cadastro) {
        this.cadastro = cadastro;
    }

    public UsuarioFormRequest() {
    }

    public UsuarioFormRequest(Long id, String nome, String email, String telefone, String senha, LocalDate cadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.cadastro = cadastro;
    }

    @Override
    public String toString() {
        return "UsuarioFormRequest [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
                + ", senha=" + senha + ", cadastro=" + cadastro + "]";
    }

    public Usuario toModel(){
        return new Usuario(id, nome, email, telefone, senha, cadastro);
    }
    public static UsuarioFormRequest fromModel(Usuario usuario){
        return new UsuarioFormRequest(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getSenha(), usuario.getDataCadastro());
    }
}
