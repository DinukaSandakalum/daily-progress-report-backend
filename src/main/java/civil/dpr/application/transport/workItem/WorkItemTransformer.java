package civil.dpr.application.transport.workItem;

import civil.dpr.application.transformer.ResponseEntityInterface;
import civil.dpr.domain.dto.workItem.WorkItemDetailResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WorkItemTransformer implements ResponseEntityInterface {

    @Override
    public Map transform(Object entity) {
        WorkItemDetailResponse response = (WorkItemDetailResponse) entity;
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("responseBody", response.getResponseBody());
        mapping.put("responseHeader", response.getResponseHeader());

        return mapping;
    }

}
