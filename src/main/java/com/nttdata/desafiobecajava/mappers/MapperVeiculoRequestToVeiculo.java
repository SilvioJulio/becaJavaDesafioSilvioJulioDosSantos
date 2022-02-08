package com.nttdata.desafiobecajava.mappers;

import com.nttdata.desafiobecajava.domains.Veiculo;
import com.nttdata.desafiobecajava.dtos.requests.VeiculoRequest;
import org.mapstruct.Mapper;

@Mapper
public interface MapperVeiculoRequestToVeiculo {

    public Veiculo toModel(VeiculoRequest veiculoRequest);
}
