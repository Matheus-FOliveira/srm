package matheus.ferraz.srm.repositories.Implementations;

import matheus.ferraz.srm.entities.Moeda;
import matheus.ferraz.srm.repositories.MoedaRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MoedaRepositoryImp implements MoedaRepository {
    private final JdbcClient jdbcClient;
    public MoedaRepositoryImp(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Moeda> findById(Integer id) {
        return this.jdbcClient
                .sql("SELECT * FROM moeda WHERE id = :id")
                .param("id", id)
                .query(Moeda.class)
                .optional();
    }

    @Override
    public List<Moeda> findAll() {
        return this.jdbcClient
                .sql("SELECT * FROM moeda")
                .query(Moeda.class)
                .list();
    }

    @Override
    public Integer add(Moeda moeda) {
        return this.jdbcClient
                .sql("INSERT INTO moeda (nomeMoeda) VALUES (:nomeMoeda)")
                .param("nomeMoeda", moeda.getNomeMoeda())
                .update();
    }

    @Override
    public Integer update(Moeda moeda, Integer id) {
        return this.jdbcClient
                .sql("UPDATE moeda SET nomeMoeda = :nomeMoeda WHERE id = :id")
                .param("id",id)
                .param("nomeMoeda", moeda.getNomeMoeda())
                .update();
    }

    @Override
    public Integer delete(Integer id) {
        return this.jdbcClient
                .sql("DELETE FROM moeda WHERE id = :id")
                .param("id", id)
                .update();
    }
}
