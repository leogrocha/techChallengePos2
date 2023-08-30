package com.techchallenge.fiap.eletrodomesticos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techchallenge.fiap.eletrodomesticos.dominio.EletrodomesticoPessoa;

@Repository
public interface EletrodomesticoPessoaRepository extends JpaRepository<EletrodomesticoPessoa, Long>{
    
}
