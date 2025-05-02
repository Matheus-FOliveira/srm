package matheus.ferraz.srm.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
@ToString
public class Transacao {
    private Integer idTransacao;
    private LocalDateTime horaTransacao;
    private Double valorFinal;
    private Integer fkProduto;
    private Integer fkMoedaOrigem;
    private Integer fkMoedaDestino;
}
