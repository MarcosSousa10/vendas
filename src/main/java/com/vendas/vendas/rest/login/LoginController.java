package com.vendas.vendas.rest.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.vendas.model.Login;
import com.vendas.vendas.model.repository.LoginRepository;
import com.vendas.vendas.rest.produtoFixo.ProdutoFixoFormRequest;

@RestController
@RequestMapping("/api/login")
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private LoginRepository repository;

    @GetMapping
    public ResponseEntity<LoginFromRequest> GetById(@RequestParam String username , @RequestParam String password){
        Optional<Login> produtoExistente= repository.login(username,password);
        if(produtoExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var produto= produtoExistente.map(LoginFromRequest::fromModel).get();
        return ResponseEntity.ok(produto);
    }
}
