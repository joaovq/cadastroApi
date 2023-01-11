package br.com.cadastroApi.controller;

import br.com.cadastroApi.entities.Pessoa;
import br.com.cadastroApi.entities.forms.PessoaForm;
import br.com.cadastroApi.service.impl.PessoaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
    @Autowired
    private PessoaServiceImpl service;
//    Verificar todas as pessoas
    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll(){
        List<Pessoa> pessoas = service.getAll();
        return ResponseEntity.ok().body(pessoas);
    }
//      Encontrar pessoa pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable Long id){
        Pessoa pessoa = service.getPessoaById(id);
        return ResponseEntity.ok().body(pessoa);
    }
    //  Criar pessoa
    @PostMapping
    public ResponseEntity<Pessoa> create(@Valid @RequestBody PessoaForm pessoaForm)  {
        Pessoa pessoa = service.insert(pessoaForm);
        return ResponseEntity.status(201).body(pessoa);
    }
//    Atualizar pessoa
    @PutMapping("/put/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id,
                                         @Valid @RequestBody PessoaForm pessoaForm)
             {
        Pessoa pessoaUpdate = service.update(id, pessoaForm);
        return ResponseEntity.status(201).body(pessoaUpdate);
    }
}
