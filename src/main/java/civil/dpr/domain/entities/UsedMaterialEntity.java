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
@Table(name = "usedmaterial")
public class UsedMaterialEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsedMaterialId")
    private Long usedMaterialId;
    @ManyToOne
    @JoinColumn(name = "MaterialEntityId", referencedColumnName = "MaterialId")
    private MaterialEntity materialEntityId;
    @Column(name = "UsedQuantity")
    private BigDecimal usedQuantity;
    @ManyToOne
    @JoinColumn(name = "WorkSummaryEntityId", referencedColumnName = "WorkSummaryId")
    private WorkSummaryEntity workSummaryEntityId;

}
