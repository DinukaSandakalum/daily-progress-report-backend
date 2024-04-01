package civil.dpr.domain.dto.boqCode;

import civil.dpr.domain.dto.ResponseHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoqCodeListResponse {

    private List<BoqCodeDetail> responseBody;
    private ResponseHeader responseHeader;

}
