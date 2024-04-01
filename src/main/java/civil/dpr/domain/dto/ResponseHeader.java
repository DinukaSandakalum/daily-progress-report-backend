
package civil.dpr.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseHeader {
    private String requestId;
    private String timestamp;
    private String code;
    private String desc;
    @JsonIgnore
    private String responseCode;

    public ResponseHeader(String requestId, String timestamp, String code, String desc) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.code = code;
        this.desc = desc;
    }
}
