package com.nttdata.desafiobecajava.exception.handle;

import com.nttdata.desafiobecajava.exception.DadosVazioNullPointerException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandleDefaultTratamentoErros {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDefault> handle (HttpMessageNotReadableException e){
        ExceptionDefault exceptionDefault = new ExceptionDefault();
        exceptionDefault.setMensagem(e.getMessage());
        exceptionDefault.setHours(LocalDateTime.now());
        exceptionDefault.setStatus(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(exceptionDefault.getStatus()).body(exceptionDefault);
    }
    @ExceptionHandler(DadosVazioNullPointerException.class)
    public ResponseEntity<ExceptionDefault> handle (DadosVazioNullPointerException e){
        ExceptionDefault exceptionDefault = new ExceptionDefault();
        exceptionDefault.setMensagem(e.getMessage());
        exceptionDefault.setHours(LocalDateTime.now());
        exceptionDefault.setStatus(HttpStatus.NOT_ACCEPTABLE.value());

        return ResponseEntity.status(exceptionDefault.getStatus()).body(exceptionDefault);
    }
    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<ExceptionDefault> handle (InvalidDataAccessApiUsageException e){
        ExceptionDefault exceptionDefault = new ExceptionDefault();
        exceptionDefault.setMensagem(e.getMessage());
        exceptionDefault.setHours(LocalDateTime.now());
        exceptionDefault.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(exceptionDefault.getStatus()).body(exceptionDefault);
    }


}
