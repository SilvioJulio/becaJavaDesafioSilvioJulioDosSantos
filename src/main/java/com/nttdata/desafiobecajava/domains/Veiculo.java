package com.nttdata.desafiobecajava.domains;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String ano;

    @NotEmpty
    @NotBlank(message = "O Campo modelo não pode está ausente ou em branco!")
    private String modelo;

    @OneToOne
    //@NotBlank(message = "O Campo tipo não pode está ausente, tem ligação com dados do veículo!")
    private Tipo tipo;
    private String placa;
    private String cor;

}
