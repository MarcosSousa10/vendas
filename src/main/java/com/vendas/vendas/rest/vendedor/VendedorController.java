package com.vendas.vendas.rest.vendedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}