package com.nttdata.desafiobecajava.services;

import com.nttdata.desafiobecajava.models.Tipo;
import com.nttdata.desafiobecajava.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TipoService {

    @Autowired
     private TipoRepository tipoRepository;

    public Tipo criarTipo(Tipo tipo) {

        Tipo tipoSalavo = tipoRepository.save(tipo);

        System.out.println("Carro adicionado ao sistema com sucesso!");

        return tipoSalavo;

    }

    public Tipo editarTipo(Tipo tipo, Long id) {

        tipo.setId(id);

        System.out.println("Tipo atualizado com sucesso" + "=>" + id);

        return tipo;
    }

    public List<Tipo> listarTipos() {

        Tipo tipo1 = new Tipo(1l, "Passeio", "Carro 4 portas");

        Tipo tipo2 = new Tipo(2l, "Profissional", "Carro 4 portas");

        Tipo tipo3 = new Tipo(3l, "Utilitário", "Carga");

        return List.of(

                tipo1,
                tipo2,
                tipo3);

    }

}
