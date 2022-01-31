package com.nttdata.desafiobecajava.services;

import com.nttdata.desafiobecajava.models.Tipo;
import com.nttdata.desafiobecajava.models.Veiculo;
import com.nttdata.desafiobecajava.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;


    public Veiculo adicionarCarro(Veiculo carro) {


        Veiculo veiculoSalvo = veiculoRepository.save(carro);

        System.out.println(carro);


        return veiculoSalvo;
    }

    public Veiculo eiditarCarro(Veiculo carro, Long id) {

        carro.setId(id);

        System.out.println("Carro atualizado com sucesso" + " => " + id);

        return carro;
    }

    public List<Veiculo> listar() {

        Tipo tipo1 = new Tipo(1l, "Passeio", "Carro 4 portas");
        tipo1.setId(1l);

        Tipo tipo2 = new Tipo(2l, "Profissional", "Carro 4 portas");
        tipo1.setId(2l);

        Tipo tipo3 = new Tipo(3l, "Utilitário", "Carga");
        tipo1.setId(3l);

        Veiculo carro1 = new Veiculo(1l, "Volkswagen", "2020", "Gol", tipo1, "JRU-0034", "Branco");
        carro1.setId(1l);

        Veiculo carro2 = new Veiculo(2l, "Chevorlet", "2010", "Onix", tipo2, "QUE-9043", "Vermelho");
        carro2.setId(2l);

        Veiculo carro3 = new Veiculo(3l, "Fiat", "2022", "Pulse", tipo1, "PAX-0480", "Preto");
        carro3.setId(3l);

        return List.of(

                carro1,
                carro2,
                carro3
        );

    }

    public Veiculo pesquisarCarro(Veiculo carro, Long id) {

        carro.setId(id);

        return carro;
    }

    public String excluirCarro(Long id) {

        return "Carro com [" + id + "] foi excluido do sistema";
    }

}
