package civil.dpr.application.dto;

import civil.dpr.application.validator.RequestEntityInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request<T> implements RequestEntityInterface {
    @Valid
    @NotNull(message = "request body must not be null")
    private T requestBody;

    @Valid
    @NotNull(message = "request header must not be null")
    private RequestHeader requestHeader;

}
