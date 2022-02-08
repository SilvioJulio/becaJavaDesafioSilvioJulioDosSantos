package com.nttdata.desafiobecajava.mappers;


import com.nttdata.desafiobecajava.domains.Veiculo;
import com.nttdata.desafiobecajava.dtos.responses.VeiculoResponse;
import org.mapstruct.Mapper;

@Mapper
public interface MapperVeiculoToVeiculoResponse {

    public VeiculoResponse toResponse(Veiculo veiculo);
}
