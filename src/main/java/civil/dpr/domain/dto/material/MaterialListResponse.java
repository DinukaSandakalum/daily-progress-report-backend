package civil.dpr.domain.dto.material;

import civil.dpr.domain.dto.ResponseHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialListResponse {

    private List<MaterialDetail> responseBody;
    private ResponseHeader responseHeader;
}
