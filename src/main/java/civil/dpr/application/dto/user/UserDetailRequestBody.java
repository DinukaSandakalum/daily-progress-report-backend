package civil.dpr.application.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailRequestBody {
    @NotNull(message = "userName must not be null")
    private String userName;

    @NotNull(message = "password must not be null")
    private String password;

}
