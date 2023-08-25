package com.techChallengePos2.pessoas_gestao_api.dto;

import java.time.LocalDate;

import com.techChallengePos2.pessoas_gestao_api.dominio.Pessoa;
import com.techChallengePos2.pessoas_gestao_api.dominio.Mocks.Parentesco;
import com.techChallengePos2.pessoas_gestao_api.dominio.Mocks.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PessoaDTO {
    
    @EqualsAndHashCode.Include private Long iddepssoa;
    private String nome;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private Parentesco parentesco;


    public PessoaDTO(Pessoa entity) {
        this(entity.getIdpessoa(), entity.getNome(), entity.getDataNascimento(), entity.getSexo(),
        entity.getParentesco());
    }


}
