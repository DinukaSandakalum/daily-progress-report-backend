package civil.dpr.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "workitem")
public class WorkItemEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WorkItemId")
    private Long workItemId;
    @Column(name = "workDescription")
    private String workDescription;
    @Column(name = "PlannedStartDate")
    private LocalDate plannedStartDate;
    @Column(name = "PlannedEndDate")
    private LocalDate plannedEndDate;

}
