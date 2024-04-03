package civil.dpr.domain.dto.material;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDetail {

    private Long materialId;
    private String materialName;
    private String uom;
    private BigDecimal materialRate;

}
