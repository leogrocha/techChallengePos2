package com.techChallengePos2.pessoas_gestao_api.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techChallengePos2.pessoas_gestao_api.dto.PessoaDTO;
import com.techChallengePos2.pessoas_gestao_api.services.PessoaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("pessoas")
@AllArgsConstructor
public class PessoaController {

    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{idpessoa}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long idpessoa) {
        return ResponseEntity.ok(service.findById(idpessoa));
    }
    
}
