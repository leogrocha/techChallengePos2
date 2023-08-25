package com.techChallengePos2.pessoas_gestao_api.services;

public class PessoaInvalidoException extends RuntimeException {
    
    public PessoaInvalidoException(String mensagem) {
        super(mensagem);
    }
}
