package com.nttdata.desafiobecajava.mappers;

import com.nttdata.desafiobecajava.domains.Tipo;
import com.nttdata.desafiobecajava.dtos.requests.TipoRequest;
import org.mapstruct.Mapper;



@Mapper
public interface MapperTipoRequestToTipo {

    public Tipo toModel(TipoRequest tipoRequest);
}
