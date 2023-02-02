package com.vendas.vendas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.vendas.model.Venda;

public interface VendasRepository extends JpaRepository<Venda, Long>{
    
}
