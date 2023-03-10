package com.vendas.vendas.rest.vendedor;

import java.util.Optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.vendas.model.Vendedor;
import com.vendas.vendas.model.repository.VendedorRespository;
import com.vendas.vendas.rest.clientes.ClienteFormRequest;

@RestController
@RequestMapping("/api/vendedor")
@CrossOrigin("*")
public class VendedorController {
    @Autowired
    private VendedorRespository repository;
    

@PostMapping()
public ResponseEntity salvar (@RequestBody VendedorFormRequest request){
Vendedor vendedor=request.toModel();

repository.save(vendedor);
return ResponseEntity.ok(VendedorFormRequest.fromModel(vendedor));
}
@GetMapping("/{id}")
public ResponseEntity getById(@PathVariable("id") Long id){
return repository.findById(id).map(VendedorFormRequest::fromModel)
.map(VendedorFR -> ResponseEntity.ok(VendedorFR))
.orElseGet((()->ResponseEntity.notFound().build()));
}
public ResponseEntity delete(@PathVariable Long id){
    return repository.findById(id).map(vendedor ->{
        repository.delete(vendedor);
        return ResponseEntity.noContent().build();
    })
    .orElseGet(()-> ResponseEntity.notFound().build());
}
@PutMapping("/{id}")
public ResponseEntity<Void> Atualizar(@PathVariable Long id, @RequestBody VendedorFormRequest request){
    Optional<Vendedor> vendedorExistente = repository.findById(id);
    if(vendedorExistente.isEmpty()){
        return ResponseEntity.notFound().build();
    }
    Vendedor vendedor = request.toModel();
    vendedor.setId(id);
    repository.save(vendedor);
    return ResponseEntity.noContent().build();
}
@GetMapping
public Page<VendedorFormRequest> getLista(
    @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
    @RequestParam(value = "cpf", required = false, defaultValue = "") String cpf,
    Pageable pageable
){
    return repository
    .buscarPorNomeCpfVendedor("%"+nome+"%","%"+cpf+"%", pageable)
    .map(VendedorFormRequest::fromModel);
    //quando o reorno e lista
    //  return repository.findAll().stream().map(ClienteFormRequest::fromModel)
    // .collect(Collectors.toList());
}
}