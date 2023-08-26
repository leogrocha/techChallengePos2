package com.techChallengePos2.pessoas_gestao_api.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techChallengePos2.pessoas_gestao_api.dominio.Pessoa;
import com.techChallengePos2.pessoas_gestao_api.dto.PessoaDTO;
import com.techChallengePos2.pessoas_gestao_api.repository.PessoaRepository;
import com.techChallengePos2.pessoas_gestao_api.services.exception.ControllerNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaService {

    private PessoaRepository repository;

    @Transactional(readOnly = true)
    public List<PessoaDTO> findAll() {
        return repository.findAll().stream()
                .map(pessoa -> new PessoaDTO(pessoa)).toList();
    }

    @Transactional(readOnly = true)
    public PessoaDTO findById(Long idpessoa) {

        Pessoa pessoa = repository.findById(idpessoa)
                .orElseThrow(() -> new ControllerNotFoundException("Recurso não encontrado"));
        return new PessoaDTO(pessoa);
    }

}
