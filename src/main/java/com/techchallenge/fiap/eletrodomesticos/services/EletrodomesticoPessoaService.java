package com.techchallenge.fiap.eletrodomesticos.services;

import org.springframework.stereotype.Service;

import com.techchallenge.fiap.eletrodomesticos.dominio.EletrodomesticoPessoa;
import com.techchallenge.fiap.eletrodomesticos.repository.EletrodomesticoPessoaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EletrodomesticoPessoaService {

    private EletrodomesticoPessoaRepository repository;

    public boolean save(EletrodomesticoPessoa eletrodomesticoPessoa) {
        var objetoEletrodomesticoPessoa = repository.save(eletrodomesticoPessoa);
        return objetoEletrodomesticoPessoa != null ? true : false;
    }
    
}
