package com.nttdata.desafiobecajava.services;

import com.nttdata.desafiobecajava.domains.Tipo;
import com.nttdata.desafiobecajava.domains.Veiculo;
import com.nttdata.desafiobecajava.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo adicionarCarro(Veiculo carro) {

        Veiculo veiculoSalvo = veiculoRepository.save(carro);

        System.out.println(carro);

        return veiculoSalvo;
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
