package civil.dpr.application.transport.workSummary;

import civil.dpr.application.transformer.ResponseEntityInterface;
import civil.dpr.domain.dto.workSummary.create.WorkSummaryCreateResponse;
import civil.dpr.domain.dto.workSummary.list.WorkSummaryListResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WorkSummaryListTransformer implements ResponseEntityInterface {

    @Override
    public Map transform(Object entity) {
        WorkSummaryListResponse response = (WorkSummaryListResponse) entity;
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("responseBody", response.getResponseBody());
        mapping.put("responseHeader", response.getResponseHeader());

        return mapping;
    }

}
