package matheus.ferraz.srm.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@EqualsAndHashCode
@ToString
public class Taxa {
    private Integer idTaxa;
    private Double valorTaxa;
    private LocalDate dataMudanca;
}
