package com.vendas.vendas.rest.dashboard;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.vendas.model.repository.ClienteRepository;
import com.vendas.vendas.model.repository.ProdutoRepository;
import com.vendas.vendas.model.repository.VendasRepository;

@RestController
@RequestMapping("/api/dashboard")
public class DaschboardController {
    @Autowired
    private VendasRepository vendas;
    @Autowired
    private ClienteRepository clientes;
    @Autowired
    private ProdutoRepository produtos;
    @GetMapping
    public DashboardData getDashBoard(){
        long vendasCount = vendas.count();
        long clienteCount = clientes.count();
        long produtosCount= produtos.count();
        var anoCorrente= LocalDate.now().getYear();
        var vendasPorMes = vendas.obterSomatoriaVendasPorMes(anoCorrente);
     
        try {
            return new DashboardData(produtosCount,clienteCount,vendasCount,vendasPorMes);
        } catch (Exception e) {
            return new DashboardData(1,1,1,1);
        }
    }
    

}
