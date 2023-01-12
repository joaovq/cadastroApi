package br.com.cadastroApi.service.impl;

import br.com.cadastroApi.entities.Endereco;
import br.com.cadastroApi.entities.forms.EnderecoForm;
import br.com.cadastroApi.entities.Pessoa;
import br.com.cadastroApi.repository.EnderecoRepository;
import br.com.cadastroApi.repository.PessoaRepository;
import br.com.cadastroApi.service.EnderecoService;
import br.com.cadastroApi.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Endereco insert(EnderecoForm endereco) {
        List<Endereco> listaDeEnderecos = enderecoRepository.findAll();

        Endereco enderecoConsultado = viaCepService.consultarCep(endereco.getCep());
        Optional<Pessoa> pessoa = pessoaRepository.findById(endereco.getPessoaId());
        pessoa.ifPresent(enderecoConsultado::setPessoa);

        enderecoConsultado.setNumero(endereco.getNumero());
        enderecoConsultado.setComplemento(endereco.getComplemento());
        enderecoConsultado.setEPrincipal(false);

        if (listaDeEnderecos.isEmpty()){
            return enderecoRepository.save(enderecoConsultado);
        }
        else if (listaDeEnderecos.contains(enderecoConsultado)){
            return enderecoConsultado;
        }

        return enderecoRepository.save(enderecoConsultado);
    }

    @Override
    public List<Endereco> getAll() {
        return enderecoRepository.findAll();
    }

    @Override
    public List<Endereco> getById(Long id) {
        return enderecoRepository.encontrarEnderecosDaPessoa(id);
    }

    @Override
    public Endereco getAdressPrincipal(Long id) {
        return enderecoRepository.encontrarEnderecoPricipalDaPessoa(id);
    }

    @Override
    public String delete(Long id) {
        enderecoRepository.deleteById(id);
        return "Delete feito";
    }


}
