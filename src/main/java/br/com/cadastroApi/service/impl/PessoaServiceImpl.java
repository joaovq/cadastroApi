package br.com.cadastroApi.service.impl;

import br.com.cadastroApi.entities.Endereco;
import br.com.cadastroApi.entities.Pessoa;
import br.com.cadastroApi.entities.forms.PessoaForm;
import br.com.cadastroApi.repository.PessoaRepository;
import br.com.cadastroApi.service.EnderecoService;
import br.com.cadastroApi.service.PessoaService;
import br.com.cadastroApi.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ViaCepService service;
    @Autowired
    private EnderecoServiceImpl enderecoService;

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
    public Pessoa insert(PessoaForm pessoaForm) {
        return salvarPessoaComCep(pessoaForm);
    }

    @Override
    public Pessoa update(Long id, PessoaForm pessoa) {
        Optional<Pessoa> pessoa1 = pessoaRepository.findById(id);
        boolean estaPresente = pessoa1.isPresent();
        if (estaPresente) {
           return salvarPessoaComCep(pessoa);
        }
        return null;
    }


    private Pessoa salvarPessoaComCep(PessoaForm pessoaForm) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaForm.getName());
        pessoa.setDataDeNascimento(pessoaForm.getBirth());
        pessoa.setEndereco(new ArrayList<>());

        service.consultarCep(pessoaForm.getEndereco().getCep());

        Pessoa save = pessoaRepository.save(pessoa);
        pessoaForm.getEndereco().setPessoaId(save.getId());

        Endereco novoEndereco = enderecoService.insert(pessoaForm.getEndereco());



        novoEndereco.setPessoa(pessoa);
        novoEndereco.setNumero(novoEndereco.getNumero());
        novoEndereco.setComplemento(novoEndereco.getComplemento());
        novoEndereco.setEPrincipal(true);


        pessoa.getEndereco().add(novoEndereco);
        return pessoaRepository.save(pessoa);
    }
}

