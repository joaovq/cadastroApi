package br.com.cadastroApi.service.impl;

import br.com.cadastroApi.entities.Endereco;
import br.com.cadastroApi.entities.Pessoa;
import br.com.cadastroApi.repository.EnderecoRepository;
import br.com.cadastroApi.repository.PessoaRepository;
import br.com.cadastroApi.service.PessoaService;
import br.com.cadastroApi.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ViaCepService service;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa getPessoaById(Long id) {
        Optional<Pessoa> pessoaEncontrada = pessoaRepository.findById(id);
        return pessoaEncontrada.orElse(null);
    }

    @Override
    public void insert(Pessoa pessoa) {
        salvarPessoaComCep(pessoa);
    }

    @Override
    public void update(Long id, Pessoa pessoa) {
        Optional<Pessoa> pessoa1 = pessoaRepository.findById(id);
        boolean estaPresente = pessoa1.isPresent();
        if (estaPresente) {
            salvarPessoaComCep(pessoa);
        }
    }


    private void salvarPessoaComCep(Pessoa pessoa) {
        String cep = pessoa.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = service.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        pessoa.setEndereco(endereco);
        pessoaRepository.save(pessoa);
    }
}