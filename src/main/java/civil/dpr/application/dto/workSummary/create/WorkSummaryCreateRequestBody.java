package civil.dpr.application.dto.workSummary.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkSummaryCreateRequestBody {

    private List<WorkSummaryCreateDetail> workSummaryCreateDetailList;

}
