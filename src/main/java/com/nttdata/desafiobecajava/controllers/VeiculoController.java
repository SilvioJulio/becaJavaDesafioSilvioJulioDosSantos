package com.nttdata.desafiobecajava.controllers;

import com.nttdata.desafiobecajava.models.Tipo;
import com.nttdata.desafiobecajava.models.Veiculo;
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

        carro.setId(id);

        System.out.println("Carro atualizado com sucesso" + " => " + id);

        return ResponseEntity.ok(carro);
    }

    @GetMapping()
    public Veiculo listarPorid() {


        return null;

    }

    @GetMapping()
    public ResponseEntity<List<Veiculo>> listar() {

        Tipo tipo1 = new Tipo(1l, "Passeio", "Carro 4 portas");
        tipo1.setId(1l);

        Tipo tipo2 = new Tipo(2l, "Profissional", "Carro 4 portas");
        tipo1.setId(2l);

        Tipo tipo3 = new Tipo(3l, "Utilitário", "Carga");
        tipo1.setId(3l);

        Veiculo carro1 = new Veiculo(1l, "Volkswagen", "2020", "Gol", tipo1, "JRU-0034", "Branco");
        carro1.setId(1l);

        Veiculo carro2 = new Veiculo(2l, "Chevorlet", "2010", "Onix", tipo2, "QUE-9043", "Vermelho");
        carro2.setId(2l);

        Veiculo carro3 = new Veiculo(3l, "Fiat", "2022", "Pulse", tipo1, "PAX-0480", "Preto");
        carro3.setId(3l);

        return ResponseEntity.ok(List.of(
                carro1,
                carro2,
                carro3
        ));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> pesquisarCarro(@PathVariable Long id) {

        Veiculo carro = new Veiculo();

        carro.setId(id);

        return ResponseEntity.ok(carro);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCarro(@PathVariable Long id) {

        return ResponseEntity.noContent().build();
    }
}

