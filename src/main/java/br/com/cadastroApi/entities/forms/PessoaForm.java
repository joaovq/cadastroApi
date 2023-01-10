package br.com.cadastroApi.entities.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaForm {
    @NonNull
    private String name;
    @NonNull
    private String birth;
    @NonNull
    private EnderecoForm endereco;
}
