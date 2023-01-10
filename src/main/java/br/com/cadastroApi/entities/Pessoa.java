package br.com.cadastroApi.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pessoa_tb")
@Data
@NoArgsConstructor
public class Pessoa {
//    TODO: adicionar lista de endereços na propertie endereco
//      Avaliar a adição de PessoaEndereco
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String birth;
    @NonNull
    @ManyToOne
    private Endereco endereco;


}
