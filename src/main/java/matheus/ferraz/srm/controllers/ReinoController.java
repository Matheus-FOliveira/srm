package matheus.ferraz.srm.controllers;

import matheus.ferraz.srm.entities.Reino;
import matheus.ferraz.srm.services.ReinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reinos")
public class ReinoController {
    private final ReinoService reinoService;

    public ReinoController(ReinoService reinoService) {
        this.reinoService = reinoService;
    }


    @GetMapping
    public ResponseEntity<List<Reino>> findAll(){
        var reinos = this.reinoService.findAllReinos();
        return ResponseEntity.ok(reinos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reino>> findById(@PathVariable("id") Integer id){
        var reino = this.reinoService.findReinoById(id);
        return ResponseEntity.ok(reino);
    }

    @PostMapping
    public ResponseEntity<Void> addReino(@RequestBody Reino reino){
        this.reinoService.addReino(reino);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Reino reino, @PathVariable("id") Integer id){
        this.reinoService.updateReino(reino, id);
        return ResponseEntity.ok().build();
    }
}
