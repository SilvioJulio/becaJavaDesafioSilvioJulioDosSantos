package com.nttdata.desafiobecajava.services;

import com.nttdata.desafiobecajava.domains.Tipo;
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

    public Tipo obter(Long id) {

        Tipo obterTipo = tipoRepository.findById(id).get();


        System.out.println(id + "Econtrado com sucesso ");

        return obterTipo;
    }

    public Tipo editarTipo(Tipo tipo, Long id) {

        Tipo atualizarService = this.obter(id);
        atualizarService.setTipoVeiculo(tipo.getTipoVeiculo());
        atualizarService.setDescricao(tipo.getDescricao());
        this.criarTipo(atualizarService);

        System.out.println("Tipo atualizado com sucesso" + "=>" + id);

        return atualizarService;
    }

    public List<Tipo> listarTipos() {

        List<Tipo> tipoList = tipoRepository.findAll();

        return tipoList;
    }

    public void deletar(Long id) {

        Tipo deletarTipo = this.obter(id);

        tipoRepository.delete(deletarTipo);
    }

}
