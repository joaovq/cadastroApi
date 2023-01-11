package br.com.cadastroApi.service;

import br.com.cadastroApi.entities.Pessoa;
import br.com.cadastroApi.entities.forms.PessoaForm;

import java.util.List;

public interface PessoaService {
    List<Pessoa> getAll();
    Pessoa getPessoaById(Long id);
    Pessoa insert(PessoaForm pessoa);

    Pessoa update(Long id, PessoaForm pessoa);

    void delete(Long id, Pessoa pessoa);
}
