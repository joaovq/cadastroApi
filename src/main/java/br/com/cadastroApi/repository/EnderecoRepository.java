package br.com.cadastroApi.repository;

import br.com.cadastroApi.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
