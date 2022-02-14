package com.nttdata.desafiobecajava.services;

import com.nttdata.desafiobecajava.domains.Veiculo;
import com.nttdata.desafiobecajava.dtos.requests.VeiculoRequest;
import com.nttdata.desafiobecajava.dtos.responses.VeiculoResponse;
import com.nttdata.desafiobecajava.mappers.MapperAtualizarVeiculo;
import com.nttdata.desafiobecajava.mappers.MapperVeiculoRequestToVeiculo;
import com.nttdata.desafiobecajava.mappers.MapperVeiculoToVeiculoResponse;
import com.nttdata.desafiobecajava.repositories.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    private  final MapperVeiculoRequestToVeiculo mapperVeiculoRequestToVeiculo;

    private final MapperVeiculoToVeiculoResponse mapperVeiculoToVeiculoResponse;

    private final MapperAtualizarVeiculo mapperAtualizarVeiculo;


    public VeiculoResponse criar(VeiculoRequest veiculoRequest) {


        Veiculo veiculo = mapperVeiculoRequestToVeiculo.toModel(veiculoRequest) ;

        veiculoRepository.save(veiculo);

        VeiculoResponse veiculoResponse = mapperVeiculoToVeiculoResponse.toResponse(veiculo);

        return veiculoResponse;
    }

    public VeiculoResponse obter(Long id) {

        Veiculo obterVeiculo = veiculoRepository.findById(id).get();

        return mapperVeiculoToVeiculoResponse.toResponse(obterVeiculo);
    }

    public VeiculoResponse editar(VeiculoRequest veiculoRequest, Long id) {

        Veiculo atualizarVeiculo = veiculoRepository.findById(id).get();

        mapperAtualizarVeiculo.atualizarVeiculo(veiculoRequest,atualizarVeiculo);

        veiculoRepository.save(atualizarVeiculo);

        return mapperVeiculoToVeiculoResponse.toResponse(atualizarVeiculo);
    }

    public List<VeiculoResponse> listar() {

        List<Veiculo> listVeiculo = veiculoRepository.findAll();

        return  listVeiculo
                .stream()
                .map(mapperVeiculoToVeiculoResponse::toResponse)
                .collect(Collectors.toList());
    }

    public void deletar(Long id) {

        veiculoRepository.deleteById(id);
    }

}
