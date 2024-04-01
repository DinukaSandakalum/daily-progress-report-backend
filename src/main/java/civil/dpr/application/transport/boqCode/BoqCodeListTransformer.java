package civil.dpr.application.transport.boqCode;

import civil.dpr.application.transformer.ResponseEntityInterface;
import civil.dpr.domain.dto.boqCode.BoqCodeListResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BoqCodeListTransformer implements ResponseEntityInterface {
    @Override
    public Map transform(Object entity) {
        BoqCodeListResponse response = (BoqCodeListResponse) entity;
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("responseBody", response.getResponseBody());
        mapping.put("responseHeader", response.getResponseHeader());

        return mapping;
    }
}
