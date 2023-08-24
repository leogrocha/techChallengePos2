package com.techChallengePos2.pessoas_gestao_api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techChallengePos2.pessoas_gestao_api.dominio.Pessoa;
import com.techChallengePos2.pessoas_gestao_api.repository.PessoaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaService {

    private PessoaRepository repository;

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    
    
}
