package civil.dpr.domain.dto.workSummary.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsedLabourDto {
    private Long usedLabourId;
    private String materialType;
    private BigDecimal quantity;

}
