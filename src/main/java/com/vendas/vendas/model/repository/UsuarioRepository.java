package com.vendas.vendas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.vendas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
