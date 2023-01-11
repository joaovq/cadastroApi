package br.com.cadastroApi.service.impl;

import br.com.cadastroApi.entities.Endereco;
import br.com.cadastroApi.entities.Pessoa;
import br.com.cadastroApi.entities.forms.EnderecoForm;
import br.com.cadastroApi.entities.forms.PessoaForm;
import br.com.cadastroApi.repository.PessoaRepository;
import br.com.cadastroApi.service.EnderecoService;
import br.com.cadastroApi.service.PessoaService;
import br.com.cadastroApi.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ViaCepService service;
    @Autowired
    private EnderecoService enderecoService;

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
        Optional<Pessoa> pessoaProcurada = pessoaRepository.findById(id);
        boolean estaPresente = pessoaProcurada.isPresent();
        if (estaPresente) {
            Pessoa pessoaEncontrada = pessoaProcurada.get();
            EnderecoForm enderecoForm = new EnderecoForm();

            enderecoForm.setCep(
                        pessoaEncontrada.getEndereco().get(0).getCep());
            enderecoForm.setNumero(
                        pessoaEncontrada.getEndereco().get(0).getNumero());
            enderecoForm.setComplemento(
                        pessoaEncontrada.getEndereco().get(0).getComplemento());
            enderecoForm.setPessoaId(pessoaRepository.count()+1);


            pessoa.setEndereco(
                    enderecoForm
            );

            Pessoa pessoaAtualizada = salvarPessoaComCep(pessoa);
            pessoaRepository.delete(pessoaEncontrada);
            Long idEnderecoNoBanco = pessoaEncontrada.getEndereco().get(0).getId();
            enderecoService.delete(idEnderecoNoBanco);
            return pessoaAtualizada;
        }
        return null;
    }

    @Override
    public void delete(Long id, Pessoa pessoa) {

    }


    private Pessoa salvarPessoaComCep(PessoaForm pessoaForm) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaForm.getNome());

        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy",
                    Locale.forLanguageTag("pt-br"));
            LocalDate localdate = LocalDate.parse(pessoaForm.getDataDeNascimento(), dateTimeFormatter);
            pessoa.setDataDeNascimento(localdate);
        }catch (Exception e){
            e.printStackTrace();
        }


        pessoa.setEndereco(new ArrayList<>());

        service.consultarCep(pessoaForm.getEndereco().getCep());

        Pessoa save = pessoaRepository.save(pessoa);
        pessoaForm.getEndereco().setPessoaId(save.getId());

        Endereco novoEndereco = enderecoService.insert(pessoaForm.getEndereco());



        novoEndereco.setPessoa(pessoa);
        novoEndereco.setNumero(novoEndereco.getNumero());
        novoEndereco.setComplemento(novoEndereco.getComplemento());
        novoEndereco.setEPrincipal(true);

        List<Endereco> enderecos = new ArrayList<>(){
            {
                add(novoEndereco);
            }
        };

        pessoa.setEndereco(enderecos);

        return pessoaRepository.save(pessoa);
    }
}

