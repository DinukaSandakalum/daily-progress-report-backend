package civil.dpr.application.transport.material;

import civil.dpr.application.transformer.ResponseEntityInterface;
import civil.dpr.domain.dto.boqCode.BoqCodeListResponse;
import civil.dpr.domain.dto.material.MaterialListResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MaterialListTransformer implements ResponseEntityInterface {
    @Override
    public Map transform(Object entity) {
        MaterialListResponse response = (MaterialListResponse) entity;
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("responseBody", response.getResponseBody());
        mapping.put("responseHeader", response.getResponseHeader());

        return mapping;
    }
}
