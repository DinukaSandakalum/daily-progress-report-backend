package civil.dpr.application.dto.workSummary.update;

import civil.dpr.domain.enums.ApprovalEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkSummaryStatusUpdateRequestDto {

    private Long workSummaryId;
    private String approvalStatus;

}
