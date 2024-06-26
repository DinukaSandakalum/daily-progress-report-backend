package civil.dpr.domain.dto.workSummary.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsedMachineryDto {

    private Long usedMachineryId;
    private String machineryType;
    private String uom;
    private BigDecimal quantity;

}
