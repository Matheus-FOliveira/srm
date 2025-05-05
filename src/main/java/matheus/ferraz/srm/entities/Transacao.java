package matheus.ferraz.srm.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
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
