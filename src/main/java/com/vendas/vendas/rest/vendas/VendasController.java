package com.vendas.vendas.rest.vendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.vendas.model.Venda;
import com.vendas.vendas.model.repository.ItemVendaRepository;
import com.vendas.vendas.model.repository.VendasRepository;

@RestController
@RequestMapping("/api/vendas")
@CrossOrigin("*")
public class VendasController {
    @Autowired
    private VendasRepository repository;
    @Autowired
    private ItemVendaRepository itemVendaRepository;
    @PostMapping
    @Transactional
    public void realizarVendas(@RequestBody Venda venda){
        repository.save(venda);
        venda.getItens().stream().forEach(iv ->iv.setVenda(venda));
        itemVendaRepository.saveAll(venda.getItens());
    }
}
