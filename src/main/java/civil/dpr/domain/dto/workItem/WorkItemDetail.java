package civil.dpr.domain.dto.workItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkItemDetail {

    private Long workItemId;
    private String workDescription;
    private LocalDate plannedStartDate;
    private LocalDate plannedEndDate;

}
