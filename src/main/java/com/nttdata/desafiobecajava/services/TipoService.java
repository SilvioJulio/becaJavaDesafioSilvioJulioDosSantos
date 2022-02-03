package com.nttdata.desafiobecajava.services;

import com.nttdata.desafiobecajava.domains.Tipo;
import com.nttdata.desafiobecajava.dtos.requests.PostTipoDtoRequest;
import com.nttdata.desafiobecajava.dtos.responses.GetTipoResponse;
import com.nttdata.desafiobecajava.dtos.responses.PostTipoDtoResponse;
import com.nttdata.desafiobecajava.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    public PostTipoDtoResponse criar(PostTipoDtoRequest postTipoDtoRequest) {

        Tipo tipo = new Tipo();

        tipo.setTipoVeiculo(postTipoDtoRequest.getTipoVeiculo());
        tipo.setDescricao(postTipoDtoRequest.getDescricao());

        Tipo tipoSalavo = tipoRepository.save(tipo);

        PostTipoDtoResponse postTipoDtoResponse = new PostTipoDtoResponse();
        postTipoDtoResponse.setIdTipo(tipoSalavo.getId());
        postTipoDtoResponse.setMensagem("Tipo criado com sucesso!!!");

        return postTipoDtoResponse;
    }

    public GetTipoResponse obter(Long id) {

        Tipo tipoObtido = tipoRepository.findById(id).get();

        GetTipoResponse getTipoResponse = new GetTipoResponse();
        getTipoResponse.setTipoVeiculo(tipoObtido.getTipoVeiculo());
        getTipoResponse.setDescricao(tipoObtido.getDescricao());
        getTipoResponse.setMensagenResponse("Tipo encontrado com sucesso!!");

        return getTipoResponse;
    }

    public PostTipoDtoResponse editar(PostTipoDtoRequest postTipoDtoRequest,Long id) {

        Tipo tipos = tipoRepository.findById(id).get();

        tipos.setTipoVeiculo(postTipoDtoRequest.getTipoVeiculo());
        tipos.setDescricao(postTipoDtoRequest.getDescricao());

        Tipo tipo = tipoRepository.save(tipos);

        PostTipoDtoResponse postTipoDtoResponse = new PostTipoDtoResponse();
        postTipoDtoResponse.setIdTipo(tipo.getId());
        postTipoDtoResponse.setMensagem("Tipo atualizado com sucesso!!!");

        return postTipoDtoResponse;
    }

    public  List<GetTipoResponse> listar() {

        List<Tipo> listaTipos = tipoRepository.findAll();

        List<GetTipoResponse> getTipoResponses = new ArrayList<>();

        listaTipos.forEach(tipos ->  {
            GetTipoResponse getTipoResponse = new GetTipoResponse();
            getTipoResponse.setMensagenResponse("Informação do tipo:");
            getTipoResponse.setTipoVeiculo(tipos.getTipoVeiculo());
            getTipoResponse.setDescricao(tipos.getDescricao());
            getTipoResponses.add(getTipoResponse);

        });

        return getTipoResponses;
    }

    public void deletar(Long id) {

        Tipo deletarTipo = tipoRepository.getById(id);

        tipoRepository.delete(deletarTipo);
    }

}
