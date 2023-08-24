package com.techChallengePos2.pessoas_gestao_api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @GetMapping
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok("Api está funcionando...");
    }
    
}
