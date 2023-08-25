package com.techChallengePos2.pessoas_gestao_api.dominio;

import java.time.LocalDate;

import com.techChallengePos2.pessoas_gestao_api.dominio.Mocks.Parentesco;
import com.techChallengePos2.pessoas_gestao_api.dominio.Mocks.Sexo;
import com.techChallengePos2.pessoas_gestao_api.dto.PessoaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_pessoas")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pessoa {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idpessoa;
    private String nome;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private Parentesco parentesco;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario idusuario;

    public Pessoa(PessoaDTO dto) {
        idpessoa = dto.getIddepssoa();
        nome = dto.getNome();
        dataNascimento = dto.getDataNascimento();
        sexo = dto.getSexo();
        parentesco = dto.getParentesco();
    }

}
