package com.nttdata.desafiobecajava.mappers;

import com.nttdata.desafiobecajava.domains.Tipo;
import com.nttdata.desafiobecajava.dtos.responses.TipoResponse;
import org.mapstruct.Mapper;

@Mapper
public interface MapperTipoToTipoResponse {

  public TipoResponse toResponse(Tipo tipo);

}
