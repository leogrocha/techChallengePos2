package com.techchallenge.fiap.pessoas.repository;

import com.techchallenge.fiap.pessoas.dominio.RelacaoFamiliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelacaoFamiliarRepository extends JpaRepository<RelacaoFamiliar, Long> {
}
