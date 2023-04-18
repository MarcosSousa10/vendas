package com.vendas.vendas.rest.produtoFixo;
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

import com.vendas.vendas.model.Produto;
import com.vendas.vendas.model.ProdutoFixo;
import com.vendas.vendas.model.repository.ProdutoFixoRepository;
import com.vendas.vendas.model.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtofixo")
@CrossOrigin("*")
public class ProdutoFixoController {
    @Autowired
    private ProdutoFixoRepository repository;
    @GetMapping
    public List<ProdutoFixoFormRequest> getLista(){
        // try {
        //   //se quiser latencia  Thread.sleep(5000);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        return repository.findAll().stream().map(p-> ProdutoFixoFormRequest.fromModel(p))
        .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoFixoFormRequest> GetById(@PathVariable Long id){
        Optional<ProdutoFixo> produtoExistente= repository.findById(id);
        if(produtoExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var produto= produtoExistente.map(ProdutoFixoFormRequest::fromModel).get();
        return ResponseEntity.ok(produto);
    }
    @PostMapping
    public ProdutoFixoFormRequest salvar (@RequestBody ProdutoFixoFormRequest produto){
         ProdutoFixo entidadeProduto=produto.toModel();
        repository.save(entidadeProduto);

        return ProdutoFixoFormRequest.fromModel(entidadeProduto);
    }
    //void esta retornando um responseentity sem corpo
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody ProdutoFixoFormRequest produto){
        Optional<ProdutoFixo> produtoExistente=repository.findById(id);
        if(produtoExistente.isEmpty()){
       //public void =>     throw new ResponseStatusException(HttpStatus.NOT_FOUND);
         return ResponseEntity.notFound().build();
        }
        ProdutoFixo entidade=produto.toModel();
        entidade.setId(id);
        repository.save(entidade);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        Optional<ProdutoFixo> produtoExistente=repository.findById(id);
        if(produtoExistente.isEmpty()){
            return ResponseEntity.notFound().build(); 
        }
        repository.delete((produtoExistente.get()));
        return ResponseEntity.noContent().build();

    }
}
