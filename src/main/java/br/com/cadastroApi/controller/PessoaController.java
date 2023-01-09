package br.com.cadastroApi.controller;

import br.com.cadastroApi.entities.Pessoa;
import br.com.cadastroApi.service.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaServiceImpl service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Pessoa>> getAll(){
        List<Pessoa> pessoas = service.getAll();
        return ResponseEntity.ok().body(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable Long id){
        Pessoa pessoa = service.getPessoaById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping("/insert")
    public ResponseEntity<String> create(@RequestBody Pessoa pessoa){
        service.insert(pessoa);
        return ResponseEntity.status(201).body("post complete");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id,@RequestBody Pessoa pessoa){
        service.update(id, pessoa);
        return ResponseEntity.status(201).body("update complete");
    }
}