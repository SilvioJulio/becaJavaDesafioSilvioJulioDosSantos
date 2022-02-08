package com.nttdata.desafiobecajava.controllers;

<<<<<<< desafio6
import com.nttdata.desafiobecajava.dtos.requests.PostTipoDtoRequest;
import com.nttdata.desafiobecajava.dtos.responses.GetTipoResponse;
import com.nttdata.desafiobecajava.dtos.responses.PostTipoDtoResponse;
=======
import com.nttdata.desafiobecajava.domains.Tipo;
import com.nttdata.desafiobecajava.dtos.requests.TipoRequest;
import com.nttdata.desafiobecajava.dtos.responses.TipoResponse;
import com.nttdata.desafiobecajava.mappers.MapperTipoToTipoResponse;
>>>>>>> local
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
<<<<<<< desafio6
    public ResponseEntity<PostTipoDtoResponse> criar(@RequestBody PostTipoDtoRequest postTipoDtoRequest) {

        PostTipoDtoResponse tipoCriado = tipoService.criar(postTipoDtoRequest);

        System.out.println("Tipo adicionado ao sistema com sucesso!");

       return ResponseEntity.created(null).body(tipoCriado);
=======
    public ResponseEntity<TipoResponse> criar(@RequestBody TipoRequest tipoRequest) {
         if(tipoRequest.getDescricao().equals(null)||tipoRequest.getDescricao().equals("")) {
             throw new RuntimeException("O campo desscrição não pode está vazio ou ausente !");
         }
        TipoResponse tipoResponse = tipoService.criar(tipoRequest);

        System.out.println("Tipo adicionado ao sistema com sucesso!");

        return ResponseEntity.created(null).body(tipoResponse);
>>>>>>> local

    }

    @PatchMapping("/{id}")
<<<<<<< desafio6
    public ResponseEntity<PostTipoDtoResponse> editar(@RequestBody PostTipoDtoRequest postTipoDtoRequest,@PathVariable Long id) {

        PostTipoDtoResponse editar = tipoService.editar(postTipoDtoRequest,id);
=======
    public ResponseEntity<TipoResponse> editar(@RequestBody TipoRequest tipoRequest, @PathVariable Long id) {

        TipoResponse editar = tipoService.editar(tipoRequest, id);
>>>>>>> local

        return ResponseEntity.ok(editar);
    }

    @GetMapping("/{id}")
<<<<<<< desafio6
    public ResponseEntity<GetTipoResponse> obter(@PathVariable Long id) {
=======
    public ResponseEntity<TipoResponse> obter(@PathVariable Long id) {
>>>>>>> local

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
