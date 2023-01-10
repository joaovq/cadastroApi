package br.com.cadastroApi.controller;

import br.com.cadastroApi.entities.Endereco;
import br.com.cadastroApi.entities.forms.EnderecoForm;
import br.com.cadastroApi.service.impl.EnderecoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoServiceImpl enderecoService;
// Encontrar todos os endereços
    @GetMapping
    private ResponseEntity<List<Endereco>> getAll(){
        List<Endereco> enderecos = enderecoService.getAll();
        return ResponseEntity.ok().body(enderecos);
    }
//    Criar endereço para pessoa
    @PostMapping
    private ResponseEntity<Endereco> insert(@Valid @RequestBody EnderecoForm endereco){
        Endereco enderecoRetornado = enderecoService.insert(endereco);
        return ResponseEntity.status(201).body(enderecoRetornado);
    }
// encontrar os endereços da pessoa
    @GetMapping("/{id}")
    private ResponseEntity<List<Endereco>> getById(@PathVariable Long id){
        List<Endereco> enderecosDaPessoa = enderecoService.getById(id);
        return ResponseEntity.status(200).body(enderecosDaPessoa);
    }
    // encontrar os endereço principal da pessoa
    @GetMapping("/{id}/principal")
    private ResponseEntity<Endereco> getPrincipalById(@PathVariable Long id){
        Endereco enderecosDaPessoa = enderecoService.getAdressPrincipal(id);
        return ResponseEntity.status(200).body(enderecosDaPessoa);
    }
}
