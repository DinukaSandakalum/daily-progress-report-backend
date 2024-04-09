package civil.dpr.application.dto.workSummary.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkSummaryStatusUpdateRequestBody {

    private List<WorkSummaryStatusUpdateRequestDto> workSummaryStatusUpdateList;

}
