package com.nttdata.desafiobecajava.domains;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotBlank(message = "Valor do campo precisa está preenchido!")
    private String tipoVeiculo;

    @NotEmpty
    @NotBlank(message = "Valor do campo precisa está preenchido!")
    private String descricao;

}
