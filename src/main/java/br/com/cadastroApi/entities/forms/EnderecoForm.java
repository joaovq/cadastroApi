package br.com.cadastroApi.entities.forms;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoForm {
    @Positive(message = "o id tem que ser positivo")
    private Long pessoaId;
    @Size(max = 8, min = 8)
    private String cep;
    @Size(max = 3)
    private String numero;
    private String complemento;
}
