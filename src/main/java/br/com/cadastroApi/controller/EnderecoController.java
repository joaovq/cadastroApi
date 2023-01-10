package br.com.cadastroApi.controller;

import br.com.cadastroApi.entities.Endereco;
import br.com.cadastroApi.service.impl.EnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @GetMapping
    private ResponseEntity<List<Endereco>> getAll(){
        List<Endereco> enderecos = enderecoService.getAll();
        return ResponseEntity.ok().body(enderecos);
    }

    @PostMapping
    private ResponseEntity<Endereco> getAll(@RequestBody Endereco endereco){
        Endereco enderecoRetornado = enderecoService.insert(endereco);
        return ResponseEntity.status(201).body(enderecoRetornado);
    }
}
