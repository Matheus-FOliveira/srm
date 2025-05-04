package matheus.ferraz.srm.services;

import matheus.ferraz.srm.entities.Produto;
import matheus.ferraz.srm.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final TaxaService taxa;

    public ProdutoService(ProdutoRepository produtoRepository, TaxaService taxa){
        this.produtoRepository = produtoRepository;
        this.taxa = taxa;
    }

    public List<Produto> findAllProdutos(){
        return this.produtoRepository.findAll();
    }

    public Optional<Produto> findProdutoById(Integer id){
        return this.produtoRepository.findById(id);
    }

    public void addProduto(Produto produto){
        var save = this.produtoRepository.add(produto);
        Assert.state(save == 1, "Erro ao salvar ");
    }

    public void updateProduto(Produto produto, Integer id){
        var update = this.produtoRepository.update(produto, id);
        if (update == 0){
            throw new RuntimeException("ID não encontrado");
        }
    }

    public void deleteProduto(Integer id){
        var delete = this.produtoRepository.delete(id);
        if (delete == 0){
            throw new RuntimeException("ID não encontrado");
        }
    }

    public Double converterOuro(Double ouro){
        var taxaAtual = this.taxa.getCurrent().get().getValorTaxa();
        return ouro * taxaAtual;
    }

    public Double converterTibar(Double tibar){
        var taxaAtual = this.taxa.getCurrent().get().getValorTaxa();
        return tibar / taxaAtual;
    }
}
