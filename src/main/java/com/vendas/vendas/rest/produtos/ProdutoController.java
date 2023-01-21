package com.vendas.vendas.rest.produtos;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vendas.vendas.model.Produto;
import com.vendas.vendas.model.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;
    @GetMapping
    public List<ProdutoFormRequest> getLista(){
        // try {
        //   //se quiser latencia  Thread.sleep(5000);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        return repository.findAll().stream().map(p-> ProdutoFormRequest.fromModel(p))
        .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoFormRequest> GetById(@PathVariable Long id){
        Optional<Produto> produtoExistente= repository.findById(id);
        if(produtoExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var produto= produtoExistente.map(ProdutoFormRequest::fromModel).get();
        return ResponseEntity.ok(produto);
    }
    @PostMapping
    public ProdutoFormRequest salvar (@RequestBody ProdutoFormRequest produto){
         Produto entidadeProduto=produto.toModel();
        repository.save(entidadeProduto);

        return ProdutoFormRequest.fromModel(entidadeProduto);
    }
    //void esta retornando um responseentity sem corpo
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody ProdutoFormRequest produto){
        Optional<Produto> produtoExistente=repository.findById(id);
        if(produtoExistente.isEmpty()){
       //public void =>     throw new ResponseStatusException(HttpStatus.NOT_FOUND);
         return ResponseEntity.notFound().build();
        }
        Produto entidade=produto.toModel();
        entidade.setId(id);
        repository.save(entidade);
        return ResponseEntity.ok().build();
    }
}
