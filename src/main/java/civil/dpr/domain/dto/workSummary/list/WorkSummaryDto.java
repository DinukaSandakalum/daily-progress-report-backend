package civil.dpr.domain.dto.workSummary.list;

import civil.dpr.domain.enums.ApprovalEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkSummaryDto {

    private Long workSummaryId;
    private String workItem;
    private LocalDate workDate;
    private BigDecimal completedQuantity;
    private String boqCode;
    private String boqName;
    private String userName;
    private List<UsedMaterialDto> usedMaterialList;
    private List<UsedLabourDto> usedLabourList;
    private List<UsedMachineryDto> usedMachineryList;
    private ApprovalEnum approvalStatus;

}
