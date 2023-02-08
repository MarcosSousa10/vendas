package com.vendas.vendas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.vendas.model.Vendedor;

public interface VendedorRespository extends JpaRepository<Vendedor,Long> {
    
}
