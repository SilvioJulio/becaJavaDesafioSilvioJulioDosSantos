package com.nttdata.desafiobecajava.dtos.responses;

import com.nttdata.desafiobecajava.domains.Tipo;
import lombok.Data;


@Data
public class VeiculoResponse {

    private Long id;
    private String marca;
    private String ano;
    private String modelo;
    private Tipo tipo;
    private String placa;
    private String cor;

}
