package civil.dpr.application.controller;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.labour.LabourListRequestBody;
import civil.dpr.application.dto.material.MaterialListRequestBody;
import civil.dpr.application.transformer.ResponseEntityTransformer;
import civil.dpr.application.transport.labour.LabourListTransformer;
import civil.dpr.domain.dto.labour.LabourListResponse;
import civil.dpr.domain.dto.material.MaterialListResponse;
import civil.dpr.domain.exception.DomainException;
import civil.dpr.domain.service.LabourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("${base-url.context}/labour")
@CrossOrigin(origins = "*")
public class LabourController extends BaseController{

    @Autowired
    private LabourService labourService;
    @Autowired
    private ResponseEntityTransformer responseEntityTransformer;
    @Autowired
    private LabourListTransformer labourListTransformer;

    @PostMapping(value = "/list")
    public ResponseEntity<Object> getLabourList(Request<LabourListRequestBody> request) throws DomainException {

        LabourListResponse labourListResponse = labourService.getLabourList(request);
        Map<String, Object> trResponse = responseEntityTransformer.transform(labourListResponse, labourListTransformer);
        return getResponseEntity(labourListResponse.getResponseHeader().getResponseCode(), trResponse);

    }

}
