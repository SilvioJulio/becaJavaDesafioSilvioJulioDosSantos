package com.nttdata.desafiobecajava.controllers;

import com.nttdata.desafiobecajava.dtos.requests.TipoRequest;
import com.nttdata.desafiobecajava.dtos.responses.TipoResponse;
import com.nttdata.desafiobecajava.exception.DadosVazioNullPointerException;
import com.nttdata.desafiobecajava.mappers.MapperTipoToTipoResponse;
import com.nttdata.desafiobecajava.services.TipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/veiculo/tipo")
public class TipoController {


    private final TipoService tipoService;

    private final MapperTipoToTipoResponse mapperTipoToTipoResponse;


    @PostMapping
    public ResponseEntity<TipoResponse> criar(@RequestBody @Valid TipoRequest tipoRequest) {

        if (tipoRequest.getDescricao() == null || tipoRequest.getDescricao().equals("")) {

            throw new DadosVazioNullPointerException("Os campos tipoVeículo ou descrição, não podem está vazio ou ausente !");
        }

        TipoResponse tipoCriado = tipoService.criar(tipoRequest);


        return ResponseEntity.created(null).body(tipoCriado);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<TipoResponse> editar(@RequestBody TipoRequest tipoRequest, @PathVariable Long id) {

        TipoResponse editar = tipoService.editar(tipoRequest, id);

        return ResponseEntity.ok(editar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoResponse> obter(@PathVariable Long id) {

        TipoResponse obterTipo = tipoService.obter(id);

        return ResponseEntity.ok(obterTipo);

    }

    @GetMapping
    public ResponseEntity<List<TipoResponse>> listar() {

        List<TipoResponse> listTipo = tipoService.listar();

        return ResponseEntity.ok(listTipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {

        tipoService.deletar(id);

        return ResponseEntity.ok("Tipo com ID=> " + "[" + id + "]" + " foi excluído com sucesso!");
    }
}
