package com.vendas.vendas.rest.CadastroCusto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.vendas.model.CadastroCusto;
import com.vendas.vendas.model.repository.CadastroCustoRepository;

@RestController
@RequestMapping("/api/Custo")
@CrossOrigin("*")
public class CadastroCustoController {
    @Autowired
    private CadastroCustoRepository repository;
    @GetMapping
    public List<CadastroCustoFormTRequest> getLista(){
        // try {
        //   //se quiser latencia  Thread.sleep(5000);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        return repository.findAll().stream().map(p-> CadastroCustoFormTRequest.fromModel(p))
        .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CadastroCustoFormTRequest> GetById(@PathVariable Long id){
        Optional<CadastroCusto> produtoExistente= repository.findById(id);
        if(produtoExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var produto= produtoExistente.map(CadastroCustoFormTRequest::fromModel).get();
        return ResponseEntity.ok(produto);
    }
    @PostMapping
    public CadastroCustoFormTRequest salvar (@RequestBody CadastroCustoFormTRequest produto){
         CadastroCusto entidadeProduto=produto.toModel();
        repository.save(entidadeProduto);

        return CadastroCustoFormTRequest.fromModel(entidadeProduto);
    }
    //void esta retornando um responseentity sem corpo
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody CadastroCustoFormTRequest produto){
        Optional<CadastroCusto> produtoExistente=repository.findById(id);
        if(produtoExistente.isEmpty()){
       //public void =>     throw new ResponseStatusException(HttpStatus.NOT_FOUND);
         return ResponseEntity.notFound().build();
        }
        CadastroCusto entidade=produto.toModel();
        entidade.setId(id);
        repository.save(entidade);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        Optional<CadastroCusto> produtoExistente=repository.findById(id);
        if(produtoExistente.isEmpty()){
            return ResponseEntity.notFound().build(); 
        }
        repository.delete((produtoExistente.get()));
        return ResponseEntity.noContent().build();

    }
}
