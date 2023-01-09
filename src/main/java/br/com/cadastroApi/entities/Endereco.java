package br.com.cadastroApi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name = "endereco_tb")
@Data
public class Endereco {
    @Id
    private String cep;
    @NonNull
    private String logradouro;
    @NonNull
    private String numero;
    @NonNull
    private String cidade;

}
