package civil.dpr.domain.entities;

import civil.dpr.domain.enums.ApprovalEnum;
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
@Table(name = "worksummary")
public class WorkSummaryEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WorkSummaryId")
    private Long workSummaryId;
    @ManyToOne
    @JoinColumn(name = "WorkItemEntityId", referencedColumnName = "WorkItemId")
    private WorkItemEntity workItemEntityId;
    @Column(name = "WorkDate")
    private String workDate;
    @ManyToOne
    @JoinColumn(name = "BoqCodeEntityId", referencedColumnName = "BoqId")
    private BoqCodeEntity boqCodeEntityId;
    @Column(name = "CompletedQuantity")
    private BigDecimal completedQuantity;
    @ManyToOne
    @JoinColumn(name = "userEntityId", referencedColumnName = "UserId")
    private UserEntity userEntityId;
    @Column(name = "ApprovalStatus")
    @Enumerated(EnumType.STRING)
    private ApprovalEnum approvalStatus;

}
