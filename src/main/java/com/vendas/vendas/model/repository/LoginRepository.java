package com.vendas.vendas.model.repository;

import java.util.List;
import java.util.Optional;

import javax.print.DocFlavor.STRING;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vendas.vendas.model.Login;
import com.vendas.vendas.model.Venda;

public interface LoginRepository extends JpaRepository<Login,String>{
    @Query(value = "SELECT extract(month from v.data_cadastro) as data_cadastro, SUM(v.lucro) as custo FROM Venda as v  where extract(month from v.data_cadastro)=?1 group by extract (month from v.data_cadastro) order by extract (month from v.data_cadastro)",nativeQuery = true)
    Optional<Login> Gasto(Integer mes);
    @Query(value = "	SELECT extract(month from v.data_cadastro) as data_cadastro, SUM(v.preco) as custo FROM cadastro_custo as v  where extract(month from v.data_cadastro)=?1 group by extract (month from v.data_cadastro) order by extract (month from v.data_cadastro);",nativeQuery = true)
    Optional<Login> Custo(Integer mes);
}
