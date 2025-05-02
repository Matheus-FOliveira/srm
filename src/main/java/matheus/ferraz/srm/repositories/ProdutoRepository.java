package matheus.ferraz.srm.repositories;

import matheus.ferraz.srm.entities.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    Optional<Produto> findById(Integer id);
    List<Produto> findAll();
    Integer add(Produto produto);
    Integer update(Produto produto, Integer id);
    Integer delete(Integer id);
}
