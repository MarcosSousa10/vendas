package com.vendas.vendas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.vendas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
