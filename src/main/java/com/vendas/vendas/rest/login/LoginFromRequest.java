package com.vendas.vendas.rest.login;

import com.vendas.vendas.model.Login;

public class LoginFromRequest {
    private Long id;
    private String senha;
    private String name;
    private String email;
    public Login toModel(){
        return new Login(id, senha, name, email);
    }
    public static LoginFromRequest fromModel(Login login){
        return new LoginFromRequest(login.getId(),login.getName(),login.getEmail(),login.getSenha());
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "login [id=" + id + ", senha=" + senha + ", name=" + name + ", email=" + email + "]";
    }
    public LoginFromRequest() {
    }
    public LoginFromRequest(Long id, String senha, String name, String email) {
        this.id = id;
        this.senha = senha;
        this.name = name;
        this.email = email;
    }
   
}
