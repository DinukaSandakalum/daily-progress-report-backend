package civil.dpr.domain.dto.user;

import civil.dpr.domain.dto.ResponseHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailResponse {

    private UserDetail responseBody;
    private ResponseHeader responseHeader;

}
