package com.techChallengePos2.pessoas_gestao_api.dto;

import com.techChallengePos2.pessoas_gestao_api.dominio.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UsuarioDTO {

    @EqualsAndHashCode.Include
    private Long idusuario;
    private String nome;

    public UsuarioDTO(Usuario entity) {
        this(entity.getIdusuario(), entity.getNome());
    }

}
