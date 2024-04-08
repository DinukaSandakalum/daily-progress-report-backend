package civil.dpr.domain.dto.user;

import civil.dpr.domain.enums.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {

    private Long userId;
    private String userName;
    private UserRoleEnum userRole;

}
