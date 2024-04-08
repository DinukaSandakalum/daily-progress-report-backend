package civil.dpr.domain.dto.workItem;

import civil.dpr.domain.dto.ResponseHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkItemDetailResponse {

    private List<WorkItemDetail> responseBody;
    private ResponseHeader responseHeader;

}
