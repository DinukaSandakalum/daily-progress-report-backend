package civil.dpr.application.transport.workSummary;

import civil.dpr.application.transformer.ResponseEntityInterface;
import civil.dpr.domain.dto.workSummary.create.WorkSummaryCreateResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WorkSummaryCreateTransformer implements ResponseEntityInterface {

    @Override
    public Map transform(Object entity) {
        WorkSummaryCreateResponse response = (WorkSummaryCreateResponse) entity;
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("responseHeader", response.getResponseHeader());

        return mapping;
    }

}
