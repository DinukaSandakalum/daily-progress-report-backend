/**
 * Copyrights 2020 Axiata Digital Labs Pvt Ltd.
 * All Rights Reserved.
 *
 * These material are unpublished, proprietary, confidential source
 * code of Axiata Digital Labs Pvt Ltd (ADL) and constitute a TRADE
 * SECRET of ADL.
 *
 * ADL retains all title to and intellectual property rights in these
 * materials.
 *
 */
package civil.dpr.application.transformer;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ResponseEntityTransformer {
    public Map transform(Object entity, ResponseEntityInterface transformer){
        return transformer.transform(entity);
    }

    public List<Map> transform(List<?> entityList, ResponseEntityInterface transformer){
        return entityList.stream().map(transformer::transform).collect(Collectors.toList());
    }
}
