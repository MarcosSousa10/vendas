package com.vendas.vendas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.vendas.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
