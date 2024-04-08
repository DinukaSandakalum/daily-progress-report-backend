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
@Table(name = "usedmachinery")
public class UsedMachineryEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsedMachineryId")
    private Long usedMachineryId;
    @ManyToOne
    @JoinColumn(name = "MachineryEntityId", referencedColumnName = "MachineryId")
    private MachineryEntity machineryEntityId;
    @Column(name = "UsedQuantity")
    private BigDecimal usedQuantity;
    @ManyToOne
    @JoinColumn(name = "WorkSummaryEntityId", referencedColumnName = "WorkSummaryId")
    private WorkSummaryEntity workSummaryEntityId;

}
