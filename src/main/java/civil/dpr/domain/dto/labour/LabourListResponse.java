package civil.dpr.domain.dto.labour;

import civil.dpr.domain.dto.ResponseHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabourListResponse {

    private List<LabourDetail> responseBody;
    private ResponseHeader responseHeader;
}
