package civil.dpr.domain.dto.machinery;

import civil.dpr.domain.dto.ResponseHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineryListResponse {

    private List<MachineryDetail> responseBody;
    private ResponseHeader responseHeader;
}
