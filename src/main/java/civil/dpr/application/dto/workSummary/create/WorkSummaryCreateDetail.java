package civil.dpr.application.dto.workSummary.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkSummaryCreateDetail {

    private Long workItemId;
    private LocalDate workDate;
    private Long boqId;
    private BigDecimal completedQuantity;
    private List<UsedMaterialDetail> usedMaterialDetailList;
    private List<UsedMachineryDetail> usedMachineryDetailList;
    private List<UsedLabourDetail> usedLabourDetailList;
    private Long userId;

}
