package matheus.ferraz.srm.services;

import matheus.ferraz.srm.entities.Transacao;
import matheus.ferraz.srm.repositories.TransacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;
    private final ProdutoService produtoService;
    private final MoedaService moedaService;
    private final TaxaService taxaService;

    public TransacaoService(TransacaoRepository transacaoRepository, ProdutoService produtoService, MoedaService moedaService, TaxaService taxaService){
        this.transacaoRepository = transacaoRepository;
        this.produtoService = produtoService;
        this.moedaService = moedaService;

        this.taxaService = taxaService;
    }

    public List<Transacao> findAllTransacaos(){
        return this.transacaoRepository.findAll();
    }

    public Optional<Transacao> findTransacaoById(Integer id){
        return this.transacaoRepository.findById(id);
    }

    public void addTransacao(Transacao transacao){
        var save = this.transacaoRepository.add(transacao);
        Assert.state(save == 1, "Erro ao salvar ");
    }

    public void updateTransacao(Transacao transacao, Integer id){
        var update = this.transacaoRepository.update(transacao, id);
        if (update == 0){
            throw new RuntimeException("ID não encontrado");
        }
    }

    public void deleteTransacao(Integer id){
        var delete = this.transacaoRepository.delete(id);
        if (delete == 0){
            throw new RuntimeException("ID não encontrado");
        }
    }

    public Double calcularValorFinal(Integer idProduto, Integer idMoedaOrigem, Integer idMoedaDestino){
        Double precoBase = this.produtoService.findProdutoById(idProduto).get().getValorOuro();
        Double taxaRegional = this.produtoService.getTaxaRegional(idProduto);
        if(idMoedaOrigem != 1){
            this.produtoService.converterOuro(precoBase);
        }
        return precoBase * taxaRegional;
    }
}
