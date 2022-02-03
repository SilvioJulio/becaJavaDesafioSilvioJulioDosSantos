package com.nttdata.desafiobecajava.controllers;

import com.nttdata.desafiobecajava.dtos.requests.PostTipoDtoRequest;
import com.nttdata.desafiobecajava.dtos.responses.GetTipoResponse;
import com.nttdata.desafiobecajava.dtos.responses.PostTipoDtoResponse;
import com.nttdata.desafiobecajava.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo/tipo")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @PostMapping
    public ResponseEntity<PostTipoDtoResponse> criar(@RequestBody PostTipoDtoRequest postTipoDtoRequest) {

        PostTipoDtoResponse tipoCriado = tipoService.criar(postTipoDtoRequest);

        System.out.println("Tipo adicionado ao sistema com sucesso!");

       return ResponseEntity.created(null).body(tipoCriado);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<PostTipoDtoResponse> editar(@RequestBody PostTipoDtoRequest postTipoDtoRequest,@PathVariable Long id) {

        PostTipoDtoResponse editar = tipoService.editar(postTipoDtoRequest,id);

        return ResponseEntity.ok(editar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetTipoResponse> obter(@PathVariable Long id) {

        GetTipoResponse obterTipo = tipoService.obter(id);

        return ResponseEntity.ok(obterTipo);
    }

    @GetMapping
    public ResponseEntity<List<GetTipoResponse>> listar() {

        List<GetTipoResponse> tipoList = tipoService.listar();

        return ResponseEntity.ok(tipoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {

        tipoService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
