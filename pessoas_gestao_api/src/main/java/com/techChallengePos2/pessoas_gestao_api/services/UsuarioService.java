package com.techChallengePos2.pessoas_gestao_api.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techChallengePos2.pessoas_gestao_api.dominio.Usuario;
import com.techChallengePos2.pessoas_gestao_api.dto.UsuarioDTO;
import com.techChallengePos2.pessoas_gestao_api.repository.UsuarioRepository;
import com.techChallengePos2.pessoas_gestao_api.services.exception.ControllerNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        return repository.findAll().stream().map(usuario -> new UsuarioDTO(usuario)).toList();
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findById(Long idusuario) {
        Usuario usuario = repository.findById(idusuario)
                .orElseThrow(() -> new ControllerNotFoundException("Recurso não encontrado"));
        return new UsuarioDTO(usuario);
    }

}
