package com.techChallengePos2.pessoas_gestao_api.dto;

import com.techChallengePos2.pessoas_gestao_api.dominio.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioDTO {

    private Long idusuario;
    private String nome;

    public UsuarioDTO(Usuario entity) {
        this(entity.getIdusuario(), entity.getNome());
    }

}
