package civil.dpr.domain.dto.workSummary.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsedMaterialDto {
    private Long usedMaterialId;
    private String materialType;
    private String uom;
    private BigDecimal quantity;

}
