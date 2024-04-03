package civil.dpr.application.controller;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.boqCode.BoqCodeListRequestBody;
import civil.dpr.application.dto.material.MaterialListRequestBody;
import civil.dpr.application.transformer.ResponseEntityTransformer;
import civil.dpr.application.transport.material.MaterialListTransformer;
import civil.dpr.domain.dto.boqCode.BoqCodeListResponse;
import civil.dpr.domain.dto.material.MaterialListResponse;
import civil.dpr.domain.exception.DomainException;
import civil.dpr.domain.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("${base-url.context}/material")
@CrossOrigin(origins = "*")
public class MaterialController extends BaseController{

    @Autowired
    private MaterialService materialService;
    @Autowired
    private ResponseEntityTransformer responseEntityTransformer;
    @Autowired
    private MaterialListTransformer materialListTransformer;

    @PostMapping(value = "/list")
    public ResponseEntity<Object> getMaterialList(Request<MaterialListRequestBody> request) throws DomainException {

        MaterialListResponse materialListResponse = materialService.getMaterialList(request);
        Map<String, Object> trResponse = responseEntityTransformer.transform(materialListResponse, materialListTransformer);
        return getResponseEntity(materialListResponse.getResponseHeader().getResponseCode(), trResponse);

    }

}
