package civil.dpr.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "machinery")
public class MachineryEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MachineryId")
    private Long machineryId;
    @Column(name = "MachineryType")
    private String machineryType;
    @Column(name = "Uom")
    private String uom;
    @Column(name = "MachineryRate")
    private BigDecimal machineryRate;

}
