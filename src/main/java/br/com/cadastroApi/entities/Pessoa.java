package br.com.cadastroApi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pessoa_tb")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pessoa {
//    TODO: adicionar lista de endereços na propertie endereco
//      Avaliar a adição de PessoaEndereco
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String nome;
    @NonNull
    private LocalDate dataDeNascimento;
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Endereco> endereco;


}
