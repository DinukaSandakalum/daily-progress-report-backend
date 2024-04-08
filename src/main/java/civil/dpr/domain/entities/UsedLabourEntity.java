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
@Table(name = "usedlabour")
public class UsedLabourEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsedLabourId")
    private Long usedLabourId;
    @ManyToOne
    @JoinColumn(name = "LabourEntityId", referencedColumnName = "LabourId")
    private LabourEntity labourEntityId;
    @Column(name = "UsedQuantity")
    private BigDecimal usedQuantity;
    @ManyToOne
    @JoinColumn(name = "WorkSummaryEntityId", referencedColumnName = "WorkSummaryId")
    private WorkSummaryEntity workSummaryEntityId;

}
