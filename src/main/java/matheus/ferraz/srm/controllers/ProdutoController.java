package matheus.ferraz.srm.controllers;

import matheus.ferraz.srm.entities.Produto;
import matheus.ferraz.srm.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;


    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        var produtos = this.produtoService.findAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable("id") Integer id){
        var produto = this.produtoService.findProdutoById(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Void> addProduto(@RequestBody Produto produto){
        this.produtoService.addProduto(produto);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/ouro")
    public ResponseEntity<Void> addOuro(
            @RequestParam String nome,
            @RequestParam Double valorOuro,
            @RequestParam Integer fkReinoOrigem){
        Double valorTibar = this.produtoService.converterOuro(valorOuro);
        Produto produto = new Produto();
        produto.setNomeProduto(nome);
        produto.setValorOuro(valorOuro);
        produto.setValorTibar(valorTibar);
        produto.setFkReinoOrigem(fkReinoOrigem);
        this.produtoService.addProduto(produto);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/tibar")
    public ResponseEntity<Void> addTibar(@RequestParam String nome,
                                         @RequestParam Double valorTibar,
                                         @RequestParam Integer fkReinoOrigem){
        Double valorOuro = this.produtoService.converterTibar(valorTibar);
        Produto produto = new Produto();
        produto.setNomeProduto(nome);
        produto.setValorOuro(valorOuro);
        produto.setValorTibar(valorTibar);
        produto.setFkReinoOrigem(fkReinoOrigem);
        this.produtoService.addProduto(produto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Produto produto, @PathVariable("id") Integer id){
        this.produtoService.updateProduto(produto, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        this.produtoService.deleteProduto(id);
        return ResponseEntity.ok().build();
    }
}
