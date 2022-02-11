package com.nttdata.desafiobecajava.domains;


import lombok.Data;
import org.springframework.context.annotation.Bean;

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

    @NotBlank(message = "Valor do campo precisa está preenchido!")
    private String tipoVeiculo;

    @NotBlank(message = "Valor do campo precisa está preenchido!")
    private String descricao;

}
