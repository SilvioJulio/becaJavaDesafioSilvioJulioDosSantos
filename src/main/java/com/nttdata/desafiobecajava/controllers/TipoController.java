package com.nttdata.desafiobecajava.controllers;

import com.nttdata.desafiobecajava.models.Tipo;
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

        tipo.setId(id);

        System.out.println("Tipo codigo:"+ id + "foi atualizado com sucesso");

        return ResponseEntity.ok(tipo);
    }

    @GetMapping
    public ResponseEntity<List<Tipo>> listar() {

        Tipo tipo1 = new Tipo(1l, "Passeio", "Carro 4 portas");

        Tipo tipo2 = new Tipo(2l, "Hatch", "Carro 4 portas");

        Tipo tipo3 = new Tipo(3l, "Utilitário", "Carga");

        return ResponseEntity.ok(List.of(

                tipo1,
                tipo2,
                tipo3
        ));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {

        return ResponseEntity.noContent().build();
    }
}
