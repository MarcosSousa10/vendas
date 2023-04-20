package com.vendas.vendas.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vendas.vendas.model.Login;

public interface LoginRepository extends JpaRepository<Login,Long>{
    @Query(value = "select l from login l where l.name like ?1 and l.senha like ?2",nativeQuery = true)
    Optional<Login> login(String username, String password);
}
