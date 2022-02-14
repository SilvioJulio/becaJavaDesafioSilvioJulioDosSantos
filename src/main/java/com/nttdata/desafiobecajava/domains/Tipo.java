package com.nttdata.desafiobecajava.domains;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@Entity
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String tipoVeiculo;

    @NotBlank(message = "Valor do campo precisa está preenchido!")
    private String descricao;

}
