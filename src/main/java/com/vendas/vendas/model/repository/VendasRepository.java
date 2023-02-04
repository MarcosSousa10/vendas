package com.vendas.vendas.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vendas.vendas.model.Venda;
import com.vendas.vendas.model.repository.projections.VendasPorMes;

public interface VendasRepository extends JpaRepository<Venda, Long> {
    @Query(value = "select extract(month from v.data_cadastro) as mes, sum(v.total) as valor from venda as v where extract(year from v.data_cadastro)=:ano group by extract (month from v.data_cadastro) order by extract (month from v.data_cadastro)",nativeQuery = true)
    List<VendasPorMes> obterSomatoriaVendasPorMes(@Param("ano") Integer ano);
}
