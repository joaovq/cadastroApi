package br.com.cadastroApi.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import java.util.Date;

@Entity
@Table(name = "pessoa_tb")
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Date birth;
    @NonNull
    private Endereco endereco;
}
