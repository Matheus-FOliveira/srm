package matheus.ferraz.srm.repositories.Implementations;

import matheus.ferraz.srm.entities.Reino;
import matheus.ferraz.srm.repositories.ReinoRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReinoRepositoryImp implements ReinoRepository {
    private final JdbcClient jdbcClient;
    public ReinoRepositoryImp(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Reino> findById(Integer id) {
        return this.jdbcClient
                .sql("SELECT * FROM reino WHERE id = :id")
                .param("id", id)
                .query(Reino.class)
                .optional();
    }

    @Override
    public List<Reino> findAll() {
        return this.jdbcClient
                .sql("SELECT * FROM reino")
                .query(Reino.class)
                .list();
    }

    @Override
    public Integer add(Reino reino) {
        return this.jdbcClient
                .sql("INSERT INTO reino (nomeReino, taxaReino) VALUES (:nomeReino, :taxaReino)")
                .param("nomeReino", reino.getNomeReino())
                .param("taxaReino", reino.getTaxaReino())
                .update();
    }

    @Override
    public Integer update(Reino reino, Integer id) {
        return this.jdbcClient
                .sql("UPDATE reino SET nomeReino = :nomeReino, taxaReino = :taxaReino WHERE id = :id")
                .param("id",id)
                .param("nomeReino", reino.getNomeReino())
                .param("taxaReino", reino.getTaxaReino())
                .update();
    }

    @Override
    public Integer delete(Integer id) {
        return this.jdbcClient
                .sql("DELETE FROM reino WHERE id = :id")
                .param("id", id)
                .update();
    }
}
