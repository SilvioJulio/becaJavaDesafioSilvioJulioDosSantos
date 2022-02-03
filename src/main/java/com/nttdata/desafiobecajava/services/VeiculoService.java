package com.nttdata.desafiobecajava.services;

import com.nttdata.desafiobecajava.domains.Veiculo;
import com.nttdata.desafiobecajava.dtos.requests.PostVeiculoDtoRequest;
import com.nttdata.desafiobecajava.dtos.responses.GetVeiculoResponse;
import com.nttdata.desafiobecajava.dtos.responses.PostVeiculoDtoResponse;
import com.nttdata.desafiobecajava.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public PostVeiculoDtoResponse adicionarCarro(PostVeiculoDtoRequest postVeiculoDtoRequest) {

        Veiculo veiculo = new Veiculo();

        veiculo.setMarca(postVeiculoDtoRequest.getMarca());
        veiculo.setModelo(postVeiculoDtoRequest.getModelo());
        veiculo.setAno(postVeiculoDtoRequest.getAno());
        veiculo.setCor(postVeiculoDtoRequest.getCor());
        veiculo.setPlaca(postVeiculoDtoRequest.getPlaca());
        veiculo.setTipo(postVeiculoDtoRequest.getTipo());

        Veiculo veiculoSalvo = veiculoRepository.save(veiculo);

        PostVeiculoDtoResponse postVeiculoDtoResponse = new PostVeiculoDtoResponse();

        postVeiculoDtoResponse.setCodigo(veiculoSalvo.getId());
        postVeiculoDtoResponse.setMensagem("Carro criado com sucesso!");

        return postVeiculoDtoResponse;
    }

    public GetVeiculoResponse obter(Long id) {

        Veiculo obterVeiculo = veiculoRepository.findById(id).get();

        GetVeiculoResponse getVeiculoResponse =  new GetVeiculoResponse();
        getVeiculoResponse.setMarca(obterVeiculo.getMarca());
        getVeiculoResponse.setModelo(obterVeiculo.getModelo());
        getVeiculoResponse.setAno(obterVeiculo.getAno());
        getVeiculoResponse.setTipo(obterVeiculo.getTipo());
        getVeiculoResponse.setPlaca(obterVeiculo.getPlaca());
        getVeiculoResponse.setCor(obterVeiculo.getCor());
        getVeiculoResponse.setMensagenResponse("Carro econtrado com sucesso! ");

        return getVeiculoResponse;
    }

    public PostVeiculoDtoResponse eiditar(PostVeiculoDtoRequest postVeiculoDtoRequest, Long id) {

        Veiculo atualizarVeiculo = veiculoRepository.findById(id).get();

        atualizarVeiculo.setMarca(postVeiculoDtoRequest.getMarca());
        atualizarVeiculo.setModelo(postVeiculoDtoRequest.getModelo());
        atualizarVeiculo.setAno(postVeiculoDtoRequest.getAno());
        atualizarVeiculo.setTipo(postVeiculoDtoRequest.getTipo());
        atualizarVeiculo.setPlaca(postVeiculoDtoRequest.getPlaca());
        atualizarVeiculo.setCor(postVeiculoDtoRequest.getCor());

        Veiculo veiculo = veiculoRepository.save(atualizarVeiculo);

        PostVeiculoDtoResponse postVeiculoDtoResponse =new PostVeiculoDtoResponse();
        postVeiculoDtoResponse.setCodigo(veiculo.getId());
        postVeiculoDtoResponse.setMensagem("Carro atualizado com sucesso!" );

        return postVeiculoDtoResponse;
    }

    public List<GetVeiculoResponse> listar() {

        List<Veiculo> listVeiculo = veiculoRepository.findAll();

        List<GetVeiculoResponse> getVeiculoResponses = new ArrayList<>();

        listVeiculo.forEach(veiculos ->{

            GetVeiculoResponse getVeiculoResponse = new GetVeiculoResponse();
            getVeiculoResponse.setMensagenResponse("Informações do carro:");
            getVeiculoResponse.setModelo(veiculos.getModelo());
            getVeiculoResponse.setMarca(veiculos.getMarca());
            getVeiculoResponse.setAno(veiculos.getAno());
            getVeiculoResponse.setTipo(veiculos.getTipo());
            getVeiculoResponse.setPlaca(veiculos.getPlaca());
            getVeiculoResponse.setCor(veiculos.getCor());
            getVeiculoResponses.add(getVeiculoResponse);

        });

        return getVeiculoResponses;

    }
    public void excluir(Long id) {

        Veiculo deletarCarro = veiculoRepository.getById(id);

        veiculoRepository.delete(deletarCarro);
    }

}
