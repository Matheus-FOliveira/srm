package matheus.ferraz.srm.controllers;

import matheus.ferraz.srm.entities.Taxa;
import matheus.ferraz.srm.services.TaxaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/taxas")
public class TaxaController {
    private final TaxaService taxaService;

    public TaxaController(TaxaService taxaService) {
        this.taxaService = taxaService;
    }

    //Retorna histórico de taxas
    @GetMapping
    public ResponseEntity<List<Taxa>> findAll(){
        var taxas = this.taxaService.findAllTaxas();
        return ResponseEntity.ok(taxas);
    }

    //Retorna a taxa atual
    @GetMapping("/atual")
    public ResponseEntity<Optional<Taxa>> findCurrent(){
        var current = this.taxaService.getCurrent();
        return ResponseEntity.ok(current);
    }
}
