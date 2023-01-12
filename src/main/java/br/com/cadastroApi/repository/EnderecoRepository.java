package br.com.cadastroApi.repository;

import br.com.cadastroApi.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query("SELECT e FROM Endereco e WHERE e.pessoa.id = :id")
    List<Endereco> encontrarEnderecosDaPessoa(Long id);
    @Query("SELECT e FROM Endereco e WHERE e.pessoa.id = :id and e.ePrincipal = true")
    Endereco encontrarEnderecoPricipalDaPessoa(Long id);
}
