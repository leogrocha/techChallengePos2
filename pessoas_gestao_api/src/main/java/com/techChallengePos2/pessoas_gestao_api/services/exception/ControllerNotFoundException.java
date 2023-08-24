package com.techChallengePos2.pessoas_gestao_api.services.exception;

public class ControllerNotFoundException extends RuntimeException{

    public ControllerNotFoundException(String message){
        super(message);
    }
    
}
