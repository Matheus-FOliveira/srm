package matheus.ferraz.srm.controllers;

import matheus.ferraz.srm.entities.Moeda;
import matheus.ferraz.srm.services.MoedaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/moedas")
public class MoedaController {
    private final MoedaService moedaService;

    public MoedaController(MoedaService moedaService) {
        this.moedaService = moedaService;
    }

    @GetMapping
    public ResponseEntity<List<Moeda>> findAll(){
        var moedas = this.moedaService.findAllMoedas();
        return ResponseEntity.ok(moedas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Moeda>> findById(@PathVariable("id") Integer id){
        var moeda = this.moedaService.findMoedaById(id);
        return ResponseEntity.ok(moeda);
    }
}
