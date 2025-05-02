package matheus.ferraz.srm.repositories;

import matheus.ferraz.srm.entities.Moeda;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;
import java.util.Optional;

public interface MoedaRepository {
    Optional<Moeda> findById(Integer id);
    List<Moeda> findAll();
    Integer add(Moeda moeda);
    Integer update(Moeda moeda, Integer id);
    Integer delete(Integer id);
}
