package com.techChallengePos2.pessoas_gestao_api.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techChallengePos2.pessoas_gestao_api.dominio.Pessoa;
import com.techChallengePos2.pessoas_gestao_api.services.PessoaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("pessoas")
@AllArgsConstructor
public class PessoaController {

    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
}
