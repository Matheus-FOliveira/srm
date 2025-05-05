package matheus.ferraz.srm.controllers;

import matheus.ferraz.srm.entities.Transacao;
import matheus.ferraz.srm.services.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacaos")
public class TransacaoController {
    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> findAll(){
        var transacaos = this.transacaoService.findAllTransacaos();
        return ResponseEntity.ok(transacaos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Transacao>> findById(@PathVariable("id") Integer id){
        var transacao = this.transacaoService.findTransacaoById(id);
        return ResponseEntity.ok(transacao);
    }

    @PostMapping
    public ResponseEntity<Void> addTransacao(@RequestParam Integer idProduto, @RequestParam Integer idMoedaOrigem, @RequestParam Integer idMoedaDestino){
        var valorFinal = this.transacaoService.calcularValorFinal(idProduto, idMoedaOrigem);
        Transacao transacao = new Transacao();
        transacao.setFkProduto(idProduto);
        transacao.setHoraTransacao(LocalDateTime.now());
        transacao.setFkMoedaOrigem(idMoedaOrigem);
        transacao.setFkMoedaDestino(idMoedaDestino);
        transacao.setValorFinal(valorFinal);
        this.transacaoService.addTransacao(transacao);
        return ResponseEntity.status(201).build();
    }
}
