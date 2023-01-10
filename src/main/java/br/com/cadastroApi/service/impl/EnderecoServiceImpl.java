package br.com.cadastroApi.service.impl;

import br.com.cadastroApi.entities.Endereco;
import br.com.cadastroApi.repository.EnderecoRepository;
import br.com.cadastroApi.service.EnderecoService;
import br.com.cadastroApi.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Endereco insert(Endereco endereco) {
        List<Endereco> listaDeEnderecos = enderecoRepository.findAll();
        Endereco enderecoConsultado = viaCepService.consultarCep(endereco.getCep());
        enderecoConsultado.setNumero(endereco.getNumero());
        enderecoConsultado.setComplemento(endereco.getComplemento());
        if (listaDeEnderecos.isEmpty()){
            return enderecoRepository.save(enderecoConsultado);
        }
        for (Endereco enderecoBanco:listaDeEnderecos){
            if (enderecoBanco.equals(endereco)){
                return enderecoBanco;
            }
        }
        return enderecoRepository.save(enderecoConsultado);
    }

    @Override
    public List<Endereco> getAll() {
        return enderecoRepository.findAll();
    }
}
