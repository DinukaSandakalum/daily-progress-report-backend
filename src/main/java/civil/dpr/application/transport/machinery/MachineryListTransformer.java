package civil.dpr.application.transport.machinery;

import civil.dpr.application.transformer.ResponseEntityInterface;
import civil.dpr.domain.dto.boqCode.BoqCodeListResponse;
import civil.dpr.domain.dto.machinery.MachineryListResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MachineryListTransformer implements ResponseEntityInterface {
    @Override
    public Map transform(Object entity) {
        MachineryListResponse response = (MachineryListResponse) entity;
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("responseBody", response.getResponseBody());
        mapping.put("responseHeader", response.getResponseHeader());

        return mapping;
    }
}
