package civil.dpr.application.dto.workSummary.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsedLabourDetail {

    private Long labourId;
    private BigDecimal quantity;

}
