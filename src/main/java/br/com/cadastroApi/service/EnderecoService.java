package br.com.cadastroApi.service;

import br.com.cadastroApi.entities.Endereco;
import br.com.cadastroApi.entities.forms.EnderecoForm;

import java.util.List;

public interface EnderecoService {
    Endereco insert(EnderecoForm endereco);
    List<Endereco> getAll();
    List<Endereco> getById(Long id);
    Endereco getAdressPrincipal(Long id);

    String delete(Long id);
}
