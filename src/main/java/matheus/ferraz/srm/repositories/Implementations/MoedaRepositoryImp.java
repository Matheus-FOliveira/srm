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
                .sql("SELECT * FROM")
                .query(Moeda.class)
                .list();
    }

    @Override
    public Integer add(Moeda moeda) {
        return 0;
    }

    @Override
    public Integer update(Moeda moeda, Integer id) {
        return 0;
    }

    @Override
    public Integer delete(Integer id) {
        return 0;
    }
}
