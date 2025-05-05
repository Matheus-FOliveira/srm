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

    public TransacaoService(TransacaoRepository transacaoRepository){
        this.transacaoRepository = transacaoRepository;
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
}
