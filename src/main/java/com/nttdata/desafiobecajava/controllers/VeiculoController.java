package com.nttdata.desafiobecajava.controllers;


import com.nttdata.desafiobecajava.dtos.requests.PostVeiculoDtoRequest;
import com.nttdata.desafiobecajava.dtos.responses.GetVeiculoResponse;
import com.nttdata.desafiobecajava.dtos.responses.PostVeiculoDtoResponse;
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
    public ResponseEntity<PostVeiculoDtoResponse> adicionar(@RequestBody PostVeiculoDtoRequest postVeiculoDtoRequest) {

        PostVeiculoDtoResponse veiculoCriao = veiculoService.adicionarCarro(postVeiculoDtoRequest);

        System.out.println("Carro adicionado ao sistema com sucesso!");

        return ResponseEntity.created(null).body(veiculoCriao);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PostVeiculoDtoResponse> eiditar(@RequestBody PostVeiculoDtoRequest postVeiculoDtoRequest, @PathVariable Long id) {

         PostVeiculoDtoResponse editar = veiculoService.eiditar(postVeiculoDtoRequest,id);

        return ResponseEntity.ok(editar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetVeiculoResponse> obter(@PathVariable Long id) {

        GetVeiculoResponse veiculoObter = veiculoService.obter(id);

        return ResponseEntity.ok(veiculoObter);
    }

    @GetMapping()
    public ResponseEntity<List<GetVeiculoResponse>> listar() {

        List<GetVeiculoResponse> veiculosList = veiculoService.listar();

        return ResponseEntity.ok(veiculosList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {

        veiculoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}

