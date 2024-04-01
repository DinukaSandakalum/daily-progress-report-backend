
package civil.dpr.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestHeader {
    @NotBlank(message = "requestId can't be null or empty")
    private String requestId;
    @NotBlank(message = "timestamp can't be null or empty")
    private String timestamp;
    @NotBlank(message = "channel can't be null or empty")
    private String channel;
    @NotBlank(message = "userId can't be null or empty")
    private String userId;
}
