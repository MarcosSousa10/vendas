package com.vendas.vendas.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.vendas.vendas.model.Vendedor;

public interface VendedorRespository extends JpaRepository<Vendedor,Long> {
    @Query("select v from Vendedor v where upper(v.nome) like upper(:nome) and v.cpf like :cpf")
    Page<Vendedor> buscarPorNomeCpfVendedor(@Param("nome") String nome,@Param("cpf") String cpf, Pageable pageable);
}

