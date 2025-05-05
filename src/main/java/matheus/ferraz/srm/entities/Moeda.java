package matheus.ferraz.srm.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Moeda {
    private Integer idMoeda;
    private String nomeMoeda;
}
