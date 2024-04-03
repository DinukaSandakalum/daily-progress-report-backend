package civil.dpr.domain.dto.labour;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabourDetail {

    private Long labourId;
    private String labourType;
    private BigDecimal labourRate;

}
