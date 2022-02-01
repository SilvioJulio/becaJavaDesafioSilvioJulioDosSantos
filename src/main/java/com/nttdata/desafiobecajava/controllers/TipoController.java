package com.nttdata.desafiobecajava.controllers;

import com.nttdata.desafiobecajava.domains.Tipo;
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
    public ResponseEntity<Tipo> criar(@RequestBody Tipo tipo) {

        Tipo tipoCriado = tipoService.criarTipo(tipo);

        System.out.println("Tipo adicionado ao sistema com sucesso!");

        return ResponseEntity.created(null).body(tipo);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Tipo> editar(@RequestBody Tipo tipo, @PathVariable Long id) {

        Tipo tipoAtualizado = tipoService.editarTipo(tipo, id);

        System.out.println("Tipo codigo:" + id + "foi atualizado com sucesso");

        return ResponseEntity.ok(tipoAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo> obter(@PathVariable Long id) {

        Tipo obterTipo = tipoService.obter(id);

        return ResponseEntity.ok(obterTipo);
    }

    @GetMapping
    public ResponseEntity<List<Tipo>> listar() {

        List<Tipo> tipoList = tipoService.listarTipos();

        return ResponseEntity.ok(tipoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {

        tipoService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
