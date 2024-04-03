package civil.dpr.domain.dto.machinery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineryDetail {

    private Long machineryId;
    private String machineryType;
    private String uom;
    private BigDecimal machineryRate;

}
