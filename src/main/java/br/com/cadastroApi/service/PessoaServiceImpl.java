package br.com.cadastroApi.service;

import br.com.cadastroApi.entities.Pessoa;
import br.com.cadastroApi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService{
    @Autowired
    private PessoaRepository repository;

    @Override
    public List<Pessoa> getAll() {
        return repository.findAll();
    }

    @Override
    public Pessoa getPessoaById(Long id) {
        Optional<Pessoa> pessoaEncontrada = repository.findById(id);
        return pessoaEncontrada.orElse(null);
    }

    @Override
    public void insert(Pessoa pessoa) {
        salvarPessoaComCep(pessoa);
    }

    @Override
    public void update(Long id, Pessoa pessoa) {
        Optional<Pessoa> pessoa1 = repository.findById(id);
        boolean estaPresente = pessoa1.isPresent();
        if (estaPresente){
            salvarPessoaComCep(pessoa);
        }
    }


    private void salvarPessoaComCep(Pessoa pessoa){

    }
}
