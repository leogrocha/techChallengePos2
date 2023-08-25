package com.techChallengePos2.pessoas_gestao_api.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techChallengePos2.pessoas_gestao_api.dto.PessoaDTO;
import com.techChallengePos2.pessoas_gestao_api.repository.PessoaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaService {

    private PessoaRepository repository;

    @Transactional(readOnly = true)
    public List<PessoaDTO> findAll() {
        return repository.findAll().stream().map(PessoaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public PessoaDTO findById(Long idpessoa) {
        return repository.findById(idpessoa).map(PessoaDTO::new).get();
    }

    
    
}
