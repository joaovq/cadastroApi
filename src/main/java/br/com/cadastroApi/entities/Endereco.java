package br.com.cadastroApi.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Entity
@Table(name = "endereco_tb")
@Data
@NoArgsConstructor
public class Endereco {
//    TODO valid the properties
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    private Boolean ePrincipal;
    private String cep;
    private String logradouro;
    private String complemento;

    @NonNull
    private String numero;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) && Objects.equals(cep, endereco.cep) && Objects.equals(logradouro, endereco.logradouro) && Objects.equals(complemento, endereco.complemento) && numero.equals(endereco.numero) && Objects.equals(bairro, endereco.bairro) && Objects.equals(localidade, endereco.localidade) && Objects.equals(uf, endereco.uf) && Objects.equals(ibge, endereco.ibge) && Objects.equals(gia, endereco.gia) && Objects.equals(ddd, endereco.ddd) && Objects.equals(siafi, endereco.siafi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, logradouro, complemento, numero, bairro, localidade, uf, ibge, gia, ddd, siafi);
    }
}
