package com.nttdata.desafiobecajava.controllers;


import com.nttdata.desafiobecajava.domains.Veiculo;
import com.nttdata.desafiobecajava.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> adicionar(@RequestBody Veiculo carro) {

        Veiculo veiculoCrido = veiculoService.adicionarCarro(carro);

        return ResponseEntity.created(null).body(carro);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Veiculo> eiditar(@RequestBody Veiculo carro, @PathVariable Long id) {

        Veiculo veiculoAtualizado = veiculoService.eiditarCarro(carro, id);

        System.out.println("Carro codigo:" + id + "foi atualizado com sucesso");

        return ResponseEntity.ok(veiculoAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> obter(@PathVariable Long id) {

        Veiculo veiculoObter = veiculoService.obter(id);

        return ResponseEntity.ok(veiculoObter);
    }


    @GetMapping()
    public ResponseEntity<List<Veiculo>> listar() {

        List<Veiculo> veiculosList = veiculoService.listar();

        return ResponseEntity.ok(veiculosList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCarro(@PathVariable Long id) {

        veiculoService.excluirCarro(id);

        return ResponseEntity.noContent().build();
    }
}

