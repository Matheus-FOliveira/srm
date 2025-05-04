package matheus.ferraz.srm.entities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Produto {
    private Integer idProduto;
    private String nomeProduto;
    private Double valorOuro;
    private Double valorTibar;
    private Integer fkReinoOrigem;
}
