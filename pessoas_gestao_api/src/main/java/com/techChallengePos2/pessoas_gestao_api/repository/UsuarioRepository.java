package com.techChallengePos2.pessoas_gestao_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techChallengePos2.pessoas_gestao_api.dominio.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
