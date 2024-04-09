package civil.dpr.domain.dto.workSummary.list;

import civil.dpr.domain.dto.ResponseHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkSummaryListResponse {

    private List<WorkSummaryDto> responseBody;
    private ResponseHeader responseHeader;

}
