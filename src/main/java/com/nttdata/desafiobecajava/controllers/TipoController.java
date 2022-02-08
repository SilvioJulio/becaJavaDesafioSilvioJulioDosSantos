package com.nttdata.desafiobecajava.controllers;

import com.nttdata.desafiobecajava.dtos.requests.TipoRequest;
import com.nttdata.desafiobecajava.dtos.responses.TipoResponse;
import com.nttdata.desafiobecajava.mappers.MapperTipoToTipoResponse;
import com.nttdata.desafiobecajava.services.TipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/veiculo/tipo")
public class TipoController {


    private final TipoService tipoService;
    private final MapperTipoToTipoResponse mapperTipoToTipoResponse;

    @PostMapping
    public ResponseEntity<TipoResponse> criar(@RequestBody TipoRequest tipoRequest) {

        TipoResponse tipoResponse = tipoService.criar(tipoRequest);

        System.out.println("Tipo adicionado ao sistema com sucesso!");

       return ResponseEntity.created(null).body(tipoResponse);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<TipoResponse> editar(@RequestBody  TipoRequest tipoRequest,@PathVariable Long id) {

        TipoResponse editar = tipoService.editar(tipoRequest,id);

        return ResponseEntity.ok(editar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoResponse> obter(@PathVariable  Long id) {

        TipoResponse obterTipo = tipoService.obter(id);

        return ResponseEntity.ok(obterTipo);
    }

    @GetMapping
    public ResponseEntity<List<TipoResponse>> listar() {

        List<TipoResponse> tipoList = tipoService.listar();

        return ResponseEntity.ok(tipoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable  Long id) {

        tipoService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
