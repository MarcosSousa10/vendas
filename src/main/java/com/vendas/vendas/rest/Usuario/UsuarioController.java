package com.vendas.vendas.rest.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.vendas.model.Usuario;
import com.vendas.vendas.model.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

@PostMapping
public UsuarioFormRequest salvar (@RequestBody UsuarioFormRequest usuario){
    Usuario entidadeUsuario=usuario.toModel();
    repository.save(entidadeUsuario);
    return UsuarioFormRequest.fromModel(entidadeUsuario);
}
}