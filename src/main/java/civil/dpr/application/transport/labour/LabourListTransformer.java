package civil.dpr.application.transport.labour;

import civil.dpr.application.transformer.ResponseEntityInterface;
import civil.dpr.domain.dto.boqCode.BoqCodeListResponse;
import civil.dpr.domain.dto.labour.LabourListResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LabourListTransformer implements ResponseEntityInterface {
    @Override
    public Map transform(Object entity) {
        LabourListResponse response = (LabourListResponse) entity;
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("responseBody", response.getResponseBody());
        mapping.put("responseHeader", response.getResponseHeader());

        return mapping;
    }
}
