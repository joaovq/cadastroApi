package br.com.cadastroApi.entities.forms;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoForm {
    @Positive(message = "o id tem que ser positivo")
    private Long pessoaId;
    private String cep;
    private String numero;
    private String complemento;
}
