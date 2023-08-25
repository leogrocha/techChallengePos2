package com.techChallengePos2.pessoas_gestao_api.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techChallengePos2.pessoas_gestao_api.dto.UsuarioDTO;
import com.techChallengePos2.pessoas_gestao_api.repository.UsuarioRepository;

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
        return repository.findById(idusuario).map(usuario -> new UsuarioDTO(usuario)).get();
    }


    
}
