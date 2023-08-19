package com.techchallenge.fiap.common.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.techchallenge.fiap.common.exception.dao.ErrorDetails;
import com.techchallenge.fiap.eletrodomesticos.dominio.Tensao;
import com.techchallenge.fiap.pessoas.dominio.Parentesco;
import com.techchallenge.fiap.pessoas.dominio.Sexo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDetails> handleNotFoundException(NotFoundException ex) {
        var details = new ErrorDetails(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDetails> handleValidationException(ValidationException ex) {
        var details = new ErrorDetails(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        var errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDetails> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        if (ex.getCause() instanceof InvalidFormatException invalidFormatException) {
            var errorMessage = determineErrorMessage(invalidFormatException);
            var details = new ErrorDetails(errorMessage, HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
        }

        var details = new ErrorDetails("Erro ao processar a requisição.", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    private String determineErrorMessage(InvalidFormatException ex) {
        if (ex.getTargetType().equals(Tensao.class)) {
            return buildErrorMessageForEnum("Tensão", Tensao.values());
        } else if (ex.getTargetType().equals(Parentesco.class)) {
            return buildErrorMessageForEnum("Parentesco", Parentesco.values());
        } else if (ex.getTargetType().equals(Sexo.class)) {
            return buildErrorMessageForEnum("Sexo", Sexo.values());
        }
        return "Valor inválido fornecido.";
    }

    private <E extends Enum<E>> String buildErrorMessageForEnum(String fieldName, E[] enumValues) {
        var allowedValues = Arrays.stream(enumValues)
                .map(Enum::name)
                .collect(Collectors.joining(", "));
        return fieldName + " inválido fornecido. Valores permitidos são: " + allowedValues;
    }
}
