package matheus.ferraz.srm.repositories.Implementations;


import matheus.ferraz.srm.entities.Taxa;
import matheus.ferraz.srm.repositories.TaxaRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaxaRepositoryImp implements TaxaRepository {
    private final JdbcClient jdbcClient;
    public TaxaRepositoryImp(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Taxa> findById(Integer id) {
        return this.jdbcClient
                .sql("SELECT * FROM taxa WHERE id = :id")
                .param("id", id)
                .query(Taxa.class)
                .optional();
    }

    @Override
    public List<Taxa> findAll() {
        return this.jdbcClient
                .sql("SELECT * FROM taxa")
                .query(Taxa.class)
                .list();
    }

    @Override
    public Integer add(Taxa taxa) {
        return this.jdbcClient
                .sql("INSERT INTO taxa (valorTaxa, dataMudanca) VALUES (:valorTaxa, :dataMudanca)")
                .param("valorTaxa", taxa.getValorTaxa())
                .param("dataMudanca", taxa.getDataMudanca())
                .update();
    }

    @Override
    public Integer update(Taxa taxa, Integer id) {
        return this.jdbcClient
                .sql("UPDATE taxa SET valorTaxa = :valorTaxa, dataMudanca = :dataMudanca WHERE id = :id")
                .param("id",id)
                .param("valorTaxa", taxa.getValorTaxa())
                .param("dataMudanca", taxa.getDataMudanca())
                .update();
    }

    @Override
    public Integer delete(Integer id) {
        return this.jdbcClient
                .sql("DELETE FROM taxa WHERE id = :id")
                .param("id", id)
                .update();
    }

    @Override
    public Optional<Taxa> getCurrent(){
        return this.jdbcClient
                .sql("SELECT * FROM taxa ORDER BY idTaxa DESC LIMIT 1")
                .query(Taxa.class)
                .optional();
    }
}
