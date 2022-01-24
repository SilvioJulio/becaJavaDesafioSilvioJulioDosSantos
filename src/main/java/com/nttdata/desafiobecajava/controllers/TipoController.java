package com.nttdata.desafiobecajava.controllers;


import com.nttdata.desafiobecajava.model.Tipo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo")
public class TipoController {

    @PostMapping("/{id}")
    public ResponseEntity<Tipo> criarTipo(@RequestBody Tipo tipo, @PathVariable Long id){

        System.out.println(tipo);

        tipo.setId(1l);

        System.out.println("Carro adicionado ao sistema com sucesso!");

        return ResponseEntity.created(null).body(tipo);

    }
    @PatchMapping("/{id}")
    public ResponseEntity<Tipo> editarTipo(@RequestBody Tipo tipo,@PathVariable Long id){
        tipo.setId(id);
        System.out.println("Tipo atualizado com sucesso" +"=>"+ id);
        return ResponseEntity.ok(tipo);
    }
    @GetMapping
    public ResponseEntity<List<Tipo>> listarTipos(){
        Tipo tipo1 = new Tipo(1,"Passeio","Carro 4 portas");

        Tipo tipo2 = new Tipo(2,"Profissional","Carro 4 portas");

        Tipo tipo3 = new Tipo(3,"Utilitário","Carga");

        return ResponseEntity.ok(List.of(
                tipo1,
                tipo2,
                tipo3
        ));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarTipo(@PathVariable Long id){
        //"Tipo excluido com sucesso" + "=>"+ id
        return ResponseEntity.noContent().build();
    }
}
