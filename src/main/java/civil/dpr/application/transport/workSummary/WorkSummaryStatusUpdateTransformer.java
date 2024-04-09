package civil.dpr.application.transport.workSummary;

import civil.dpr.application.transformer.ResponseEntityInterface;
import civil.dpr.domain.dto.workSummary.list.WorkSummaryListResponse;
import civil.dpr.domain.dto.workSummary.statusUpdate.WorkSummaryStatusUpdateResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WorkSummaryStatusUpdateTransformer implements ResponseEntityInterface {

    @Override
    public Map transform(Object entity) {
        WorkSummaryStatusUpdateResponse response = (WorkSummaryStatusUpdateResponse) entity;
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("responseHeader", response.getResponseHeader());

        return mapping;
    }

}
