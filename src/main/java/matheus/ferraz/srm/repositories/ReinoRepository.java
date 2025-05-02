package matheus.ferraz.srm.repositories;

import matheus.ferraz.srm.entities.Reino;

import java.util.List;
import java.util.Optional;

public interface ReinoRepository {
    Optional<Reino> findById(Integer id);
    List<Reino> findAll();
    Integer add(Reino reino);
    Integer update(Reino reino, Integer id);
    Integer delete(Integer id);
}
