package matheus.ferraz.srm.repositories;

import matheus.ferraz.srm.entities.Taxa;

import java.util.List;
import java.util.Optional;

public interface TaxaRepository {
    Optional<Taxa> findById(Integer id);
    List<Taxa> findAll();
    Integer add(Taxa taxa);
    Integer update(Taxa taxa, Integer id);
    Integer delete(Integer id);
}
