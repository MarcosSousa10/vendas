package com.vendas.vendas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.vendas.model.ItemVenda;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {
    
}
