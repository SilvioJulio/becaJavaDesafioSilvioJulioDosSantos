package com.nttdata.desafiobecajava.domains;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String ano;
    private String modelo;

    @OneToOne
    private Tipo tipo;
    private String placa;
    private String cor;

}
