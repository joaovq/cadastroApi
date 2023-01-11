package br.com.cadastroApi.entities.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaForm {
    @NonNull
    private String nome;
    @NonNull
    private String dataDeNascimento;
    @NonNull
    private EnderecoForm endereco;
}
