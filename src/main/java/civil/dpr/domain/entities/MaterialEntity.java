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
@Table(name = "material")
public class MaterialEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaterialId")
    private Long materialId;
    @Column(name = "MaterialName")
    private String materialName;
    @Column(name = "Uom")
    private String uom;
    @Column(name = "MaterialRate")
    private BigDecimal materialRate;

}
