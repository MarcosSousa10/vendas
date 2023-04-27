package com.vendas.vendas.rest.login;

import java.util.HashMap;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lowagie.text.List;
import com.vendas.vendas.model.Login;
import com.vendas.vendas.model.Venda;
import com.vendas.vendas.model.repository.LoginRepository;
import com.vendas.vendas.model.repository.VendasRepository;
import com.vendas.vendas.rest.produtoFixo.ProdutoFixoFormRequest;
import com.vendas.vendas.rest.produtos.ProdutoFormRequest;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LoginController {
        @Autowired
        private LoginRepository repository;
        
        // @GetMapping("/perguntas")
	    // public Optional<Login> pergunta(@RequestParam Integer mes) {
        //    // public List<Produto> codauxiliar(@RequestParam String username) {
	    // 	Optional<Login> list = repository.Gasto(mes);
        //         return list;
	    // }
        @GetMapping("/codigo/{codigo}")
        public ResponseEntity<?> findCode(@PathVariable Integer codigo) {
            Optional<Login> list = repository.Gasto(codigo);
            return new ResponseEntity<>(list, HttpStatus.valueOf(202));
            
}
@GetMapping("/codigoCusto/{codigo}")
public ResponseEntity<?> findCodes(@PathVariable Integer codigo) {
    Optional<Login> list = repository.Custo(codigo);
    return new ResponseEntity<>(list, HttpStatus.valueOf(202));

}   

}