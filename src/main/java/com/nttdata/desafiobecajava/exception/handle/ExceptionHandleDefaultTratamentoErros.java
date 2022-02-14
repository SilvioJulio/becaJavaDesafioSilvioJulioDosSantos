package com.nttdata.desafiobecajava.exception.handle;

import com.nttdata.desafiobecajava.exception.DadosVazioNullPointerException;
import com.sun.net.httpserver.Authenticator;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.NotNullExpression;
import org.hibernate.hql.internal.ast.tree.Statement;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.w3c.dom.events.Event;


import javax.naming.NotContextException;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandleDefaultTratamentoErros {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDefault> handle(HttpMessageNotReadableException e) {
        ExceptionDefault exceptionDefault = new ExceptionDefault();
        exceptionDefault.setMensagem(e.getMessage());
        exceptionDefault.setHours(LocalDateTime.now());
        exceptionDefault.setStatus(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(exceptionDefault.getStatus()).body(exceptionDefault);
    }

    @ExceptionHandler(DadosVazioNullPointerException.class)
    public ResponseEntity<ExceptionDefault> handle(DadosVazioNullPointerException e) {
        ExceptionDefault exceptionDefault = new ExceptionDefault();
        exceptionDefault.setMensagem(e.getMessage());
        exceptionDefault.setHours(LocalDateTime.now());
        exceptionDefault.setStatus(HttpStatus.NOT_ACCEPTABLE.value());

        return ResponseEntity.status(exceptionDefault.getStatus()).body(exceptionDefault);
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<ExceptionDefault> handle(InvalidDataAccessApiUsageException e) {
        ExceptionDefault exceptionDefault = new ExceptionDefault();
        exceptionDefault.setMensagem(e.getMessage());
        exceptionDefault.setHours(LocalDateTime.now());
        exceptionDefault.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(exceptionDefault.getStatus()).body(exceptionDefault);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ExceptionDefault> handle(EmptyResultDataAccessException e) {
        ExceptionDefault exceptionDefault = new ExceptionDefault();
        exceptionDefault.setMensagem("Id não existe na base de dados, por favor verificar o ID informado!");
        exceptionDefault.setHours(LocalDateTime.now());
        exceptionDefault.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(exceptionDefault.getStatus()).body(exceptionDefault);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDefault> handle(ConstraintViolationException e) {
        ExceptionDefault exceptionDefault = new ExceptionDefault();
        exceptionDefault.setMensagem(" Os campos não pode está vazio ou em branco!");
        exceptionDefault.setHours(LocalDateTime.now());
        exceptionDefault.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(exceptionDefault.getStatus()).body(exceptionDefault);
    }


}
