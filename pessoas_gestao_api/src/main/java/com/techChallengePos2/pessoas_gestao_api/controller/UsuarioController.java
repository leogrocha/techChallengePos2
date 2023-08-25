package com.techChallengePos2.pessoas_gestao_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techChallengePos2.pessoas_gestao_api.dto.UsuarioDTO;
import com.techChallengePos2.pessoas_gestao_api.services.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{idusuario}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long idusuario) {
        return ResponseEntity.ok(service.findById(idusuario));
    }
    
}
