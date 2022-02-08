package com.nttdata.desafiobecajava.services;

import com.nttdata.desafiobecajava.domains.Tipo;
import com.nttdata.desafiobecajava.dtos.requests.TipoRequest;
import com.nttdata.desafiobecajava.dtos.responses.TipoResponse;
import com.nttdata.desafiobecajava.mappers.MapperTipoAtualizar;
import com.nttdata.desafiobecajava.mappers.MapperTipoRequestToTipo;
import com.nttdata.desafiobecajava.mappers.MapperTipoToTipoResponse;
import com.nttdata.desafiobecajava.repositories.TipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TipoService {

    private final TipoRepository tipoRepository;

    private final MapperTipoRequestToTipo mapperTipoRequestToTipo;

    private  final MapperTipoToTipoResponse mapperTipoToTipoResponse;

    private  final MapperTipoAtualizar mapperTipoAtualizar;

    public TipoResponse criar(TipoRequest tipoRequest) {

        Tipo tipo = mapperTipoRequestToTipo.toModel(tipoRequest);

        tipoRepository.save(tipo);

        TipoResponse tipoResponse = mapperTipoToTipoResponse.toResponse(tipo);

        return tipoResponse;
    }

    public TipoResponse obter(Long id) {

        Tipo obterTipo = tipoRepository.findById(id).get();

        return mapperTipoToTipoResponse.toResponse(obterTipo);
    }

    public TipoResponse editar(TipoRequest tipoRequest,Long id) {

        Tipo tipo = tipoRepository.findById(id).get();

        mapperTipoAtualizar.atualizar(tipoRequest,tipo);

        tipoRepository.save(tipo);

        return mapperTipoToTipoResponse.toResponse(tipo);
    }

    public List<TipoResponse> listar() {

        List<Tipo> listaTipos = tipoRepository.findAll();

        return listaTipos
                .stream()
                .map(mapperTipoToTipoResponse::toResponse)
                .collect(Collectors.toList());
    }

    public void deletar(Long id) {

        tipoRepository.deleteById(id);
    }

}
