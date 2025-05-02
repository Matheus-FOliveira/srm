package matheus.ferraz.srm.repositories.Implementations;


import matheus.ferraz.srm.entities.Produto;
import matheus.ferraz.srm.repositories.ProdutoRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepositoryImp implements ProdutoRepository {
    private final JdbcClient jdbcClient;
    public ProdutoRepositoryImp(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Produto> findById(Integer id) {
        return this.jdbcClient
                .sql("SELECT * FROM produto WHERE id = :id")
                .param("id", id)
                .query(Produto.class)
                .optional();
    }

    @Override
    public List<Produto> findAll() {
        return this.jdbcClient
                .sql("SELECT * FROM produto")
                .query(Produto.class)
                .list();
    }

    @Override
    public Integer add(Produto produto) {
        return this.jdbcClient
                .sql("INSERT INTO produto (nomeProduto, valorOuro, valorTibar, fkReinoOrigem) VALUES (:nomeProduto, :valorOuro, :valorTibar, :fkReinoOrigem)")
                .param("nomeProduto", produto.getNomeProduto())
                .param("valorOuro", produto.getValorOuro())
                .param("valorTibar", produto.getValorTibar())
                .param("fkReinoOrigem", produto.getFkReinoOrigem())
                .update();
    }

    @Override
    public Integer update(Produto produto, Integer id) {
        return this.jdbcClient
                .sql("UPDATE produto SET nomeProduto = :nomeProduto, valorOuro = :valorOuro, valorTibar = :valorTibar, fkReinoOrigem = :fkReinoOrigem WHERE id = :id")
                .param("id",id)
                .param("nomeProduto", produto.getNomeProduto())
                .param("valorOuro", produto.getValorOuro())
                .param("valorTibar", produto.getValorTibar())
                .param("fkReinoOrigem", produto.getFkReinoOrigem())
                .update();
    }

    @Override
    public Integer delete(Integer id) {
        return this.jdbcClient
                .sql("DELETE FROM produto WHERE id = :id")
                .param("id", id)
                .update();
    }
}
