package com.nttdata.desafiobecajava.mappers;

import com.nttdata.desafiobecajava.domains.Veiculo;
import com.nttdata.desafiobecajava.dtos.requests.VeiculoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperAtualizarVeiculo {

    public void atualizarVeiculo(VeiculoRequest veiculoRequest, @MappingTarget Veiculo veiculo);
}
