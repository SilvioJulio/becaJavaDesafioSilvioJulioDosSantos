package com.nttdata.desafiobecajava.controllers;


import com.nttdata.desafiobecajava.dtos.requests.VeiculoRequest;
import com.nttdata.desafiobecajava.dtos.responses.TipoResponse;
import com.nttdata.desafiobecajava.dtos.responses.VeiculoResponse;
import com.nttdata.desafiobecajava.exception.DadosVazioNullPointerException;
import com.nttdata.desafiobecajava.mappers.MapperVeiculoToVeiculoResponse;
import com.nttdata.desafiobecajava.services.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/veiculo")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    private final MapperVeiculoToVeiculoResponse mapperVeiculoToVeiculoResponse;

    @PostMapping
    public ResponseEntity<VeiculoResponse> criar(@RequestBody @Valid VeiculoRequest veiculoRequest) {

        if (veiculoRequest.getPlaca() == null || veiculoRequest.getPlaca().equals("") ||
                veiculoRequest.getModelo() == null || veiculoRequest.getModelo().equals("")) {

            throw new DadosVazioNullPointerException("Os campos placa do carro ou moodelo não pode está nulo ou sem informação ");

        }

        VeiculoResponse veiculoCriado = veiculoService.criar(veiculoRequest);


        return ResponseEntity.created(null).body(veiculoCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VeiculoResponse> editar(@RequestBody VeiculoRequest veiculoRequest, @PathVariable Long id) {

        VeiculoResponse editar = veiculoService.editar(veiculoRequest, id);

        return ResponseEntity.ok(editar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponse> obter(@PathVariable Long id) {

        VeiculoResponse veiculoObter = veiculoService.obter(id);

        return ResponseEntity.ok(veiculoObter);
    }

    @GetMapping()
    public ResponseEntity<List<VeiculoResponse>> listar() {

        List<VeiculoResponse> veiculosList = veiculoService.listar();

        return ResponseEntity.ok(veiculosList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {

        veiculoService.deletar(id);

        return ResponseEntity.ok("Veiculo com ID=> " + "[" + id + "]" + " foi excluído com sucesso!");
    }
}

