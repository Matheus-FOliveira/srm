package matheus.ferraz.srm.entities;

import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
public class Produto {
    private Integer idProduto;
    private String nome;
    private Double valorOuro;
    private Double valorTibar;
    private Integer fkReinoOrigem;
}
