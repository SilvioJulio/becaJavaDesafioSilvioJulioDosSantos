package com.nttdata.desafiobecajava.dtos.requests;

import lombok.Data;

import javax.persistence.Column;


@Data
public class TipoRequest {

    private String tipoVeiculo;
    private String descricao;
}
