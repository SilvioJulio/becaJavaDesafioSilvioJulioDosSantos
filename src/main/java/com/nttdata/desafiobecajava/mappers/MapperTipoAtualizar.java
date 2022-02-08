package com.nttdata.desafiobecajava.mappers;

import com.nttdata.desafiobecajava.domains.Tipo;
import com.nttdata.desafiobecajava.dtos.requests.TipoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperTipoAtualizar {

    public void atualizar(TipoRequest tipoRequest, @MappingTarget Tipo tipo);
}
