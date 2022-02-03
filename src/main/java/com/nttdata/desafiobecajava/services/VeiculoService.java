package com.nttdata.desafiobecajava.services;

import com.nttdata.desafiobecajava.domains.Tipo;
import com.nttdata.desafiobecajava.domains.Veiculo;
import com.nttdata.desafiobecajava.dtos.requests.PostVeiculoDtoRequest;
import com.nttdata.desafiobecajava.dtos.responses.PostVeiculoDtoResponse;
import com.nttdata.desafiobecajava.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public Veiculo obter(Long id) {

        Veiculo obterVeiculo = veiculoRepository.findById(id).get();

        System.out.println("Veículom de " + id + "econtrado com sucesso ");

        return obterVeiculo;
    }

    public Veiculo eiditarCarro(Veiculo carro, Long id) {

        Veiculo atualizarVeiculo = this.obter(id);

        atualizarVeiculo.setMarca(carro.getMarca());

        atualizarVeiculo.setAno(carro.getAno());

        atualizarVeiculo.setModelo(carro.getModelo());

        atualizarVeiculo.setPlaca(carro.getPlaca());

        atualizarVeiculo.setCor(carro.getCor());

        this.adicionarCarro(atualizarVeiculo);

        System.out.println("Carro atualizado com sucesso" + " => " + id);

        return atualizarVeiculo;
    }

    public List<Veiculo> listar() {

        List<Veiculo> listVeiculo = veiculoRepository.findAll();

        return listVeiculo;

    }

    public Veiculo pesquisarCarro(Veiculo carro, Long id) {

        carro.setId(id);

        return carro;
    }

    public void excluirCarro(Long id) {

        Veiculo deletarCarro = this.obter(id);

        veiculoRepository.delete(deletarCarro);
    }

}
