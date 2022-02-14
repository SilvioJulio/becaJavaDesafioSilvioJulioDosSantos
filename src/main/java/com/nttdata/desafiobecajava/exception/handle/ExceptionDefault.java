package com.nttdata.desafiobecajava.exception.handle;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionDefault {

    private Integer status;
    private String mensagem;
    private LocalDateTime hours;
}
