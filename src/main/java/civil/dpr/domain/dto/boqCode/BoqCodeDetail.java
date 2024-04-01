package civil.dpr.domain.dto.boqCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoqCodeDetail {

    private Long boqId;
    private String boqCode;
    private String boqDescription;
    private BigDecimal rate;
    private String uom;

}
