package com.vendas.vendas.rest.vendas;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.vendas.model.Venda;
import com.vendas.vendas.model.repository.VendasRepository;

@RestController
@RequestMapping("/api/vendas")
@CrossOrigin("*")
public class VendasController {
    private VendasRepository repository;
    @PostMapping
    public void realizarVendas(@RequestBody Venda venda){
        
    }
}
