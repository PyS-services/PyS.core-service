package pys.core.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class PosicionIva extends Auditable {

    @Id
    private Integer posicionIvaId;

    private String nombre;
    private Integer idPosicionIvaArca;

}
