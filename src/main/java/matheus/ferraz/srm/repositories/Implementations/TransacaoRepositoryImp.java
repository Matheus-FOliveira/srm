package matheus.ferraz.srm.repositories.Implementations;

import matheus.ferraz.srm.entities.Transacao;
import matheus.ferraz.srm.repositories.TransacaoRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TransacaoRepositoryImp implements TransacaoRepository {
    private final JdbcClient jdbcClient;
    public TransacaoRepositoryImp(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Transacao> findById(Integer id) {
        return this.jdbcClient
                .sql("SELECT * FROM transacao WHERE idTransacao = :id")
                .param("id", id)
                .query(Transacao.class)
                .optional();
    }

    @Override
    public List<Transacao> findAll() {
        return this.jdbcClient
                .sql("SELECT * FROM transacao")
                .query(Transacao.class)
                .list();
    }

    @Override
    public Integer add(Transacao transacao) {
        return this.jdbcClient
                .sql("INSERT INTO transacao (horaTransacao, valorFinal, fkProduto, fkMoedaOrigem, fkMoedaDestino) VALUES (:horaTransacao, :valorFinal, :fkProduto, :fkMoedaOrigem, :fkMoedaDestino)")
                .param("horaTransacao", transacao.getHoraTransacao())
                .param("valorFinal", transacao.getValorFinal())
                .param("fkProduto", transacao.getFkProduto())
                .param("fkMoedaOrigem", transacao.getFkMoedaOrigem())
                .param("fkMoedaDestino", transacao.getFkMoedaDestino())
                .update();
    }

    @Override
    public Integer update(Transacao transacao, Integer id) {
        return this.jdbcClient
                .sql("UPDATE transacao SET horaTransacao = :horaTransacao, valorFinal = :valorFinal, fkProduto = :fkProduto, fkMoedaOrigem = :fkMoedaOrigem, fkMoedaDestino = :fkMoedaDestino WHERE idTransacao = :id")
                .param("id",id)
                .param("horaTransacao", transacao.getHoraTransacao())
                .param("valorFinal", transacao.getValorFinal())
                .param("fkProduto", transacao.getFkProduto())
                .param("fkMoedaOrigem", transacao.getFkMoedaOrigem())
                .param("fkMoedaDestino", transacao.getFkMoedaDestino())
                .update();
    }

    @Override
    public Integer delete(Integer id) {
        return this.jdbcClient
                .sql("DELETE FROM transacao WHERE idTransacao = :id")
                .param("id", id)
                .update();
    }
}
