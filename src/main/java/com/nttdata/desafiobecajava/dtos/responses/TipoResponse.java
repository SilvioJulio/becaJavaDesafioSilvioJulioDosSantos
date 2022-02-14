package com.nttdata.desafiobecajava.dtos.responses;

import lombok.Data;

import javax.persistence.Column;

@Data
public class TipoResponse {

    private Long id;
    private String tipoVeiculo;
    private String descricao;


}
