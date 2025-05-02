package matheus.ferraz.srm.repositories;

import matheus.ferraz.srm.entities.Transacao;

import java.util.List;
import java.util.Optional;

public interface TransacaoRepository {
    Optional<Transacao> findById(Integer id);
    List<Transacao> findAll();
    Integer add(Transacao transacao);
    Integer update(Transacao transacao, Integer id);
    Integer delete(Integer id);
}
