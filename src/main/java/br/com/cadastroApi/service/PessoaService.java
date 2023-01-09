package br.com.cadastroApi.service;

import br.com.cadastroApi.entities.Pessoa;

import java.util.ArrayList;
import java.util.List;

public interface PessoaService {
    List<Pessoa> getAll();
    Pessoa getPessoaById(Long id);
    void insert(Pessoa pessoa);

    void update(Long id, Pessoa pessoa);
}
