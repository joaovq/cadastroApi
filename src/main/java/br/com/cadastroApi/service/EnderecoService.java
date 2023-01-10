package br.com.cadastroApi.service;

import br.com.cadastroApi.entities.Endereco;

import java.util.List;

public interface EnderecoService {
    Endereco insert(Endereco endereco);
    List<Endereco> getAll();
}
