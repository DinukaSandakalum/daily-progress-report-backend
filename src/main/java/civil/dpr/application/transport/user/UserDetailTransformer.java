package civil.dpr.application.transport.user;

import civil.dpr.application.transformer.ResponseEntityInterface;
import civil.dpr.domain.dto.material.MaterialListResponse;
import civil.dpr.domain.dto.user.UserDetailResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDetailTransformer implements ResponseEntityInterface {

    @Override
    public Map transform(Object entity) {
        UserDetailResponse response = (UserDetailResponse) entity;
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("responseBody", response.getResponseBody());
        mapping.put("responseHeader", response.getResponseHeader());

        return mapping;
    }

}
