package com.nttdata.desafiobecajava.dtos.requests;

import com.nttdata.desafiobecajava.domains.Tipo;
import lombok.Data;



@Data
public class VeiculoRequest  {

    private String marca;
    private String ano;
    private String modelo;
    private Tipo tipo;
    private String placa;
    private String cor;

}
