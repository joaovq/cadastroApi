package br.com.cadastroApi.controller;

import br.com.cadastroApi.entities.Pessoa;
import br.com.cadastroApi.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
//TODO: add methods at address
    /*
    * TODO:
        Criar endereço para pessoa
        Listar endereços da pessoa
        Poder informar qual endereço é o principal da pessoa
    * */
    @Autowired
    private PessoaServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll(){
        List<Pessoa> pessoas = service.getAll();
        return ResponseEntity.ok().body(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable Long id){
        Pessoa pessoa = service.getPessoaById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa){
        service.insert(pessoa);
        return ResponseEntity.status(201).body(pessoa);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@RequestBody Pessoa pessoa){
        service.update(id, pessoa);
        return ResponseEntity.status(201).body("update complete");
    }
}
