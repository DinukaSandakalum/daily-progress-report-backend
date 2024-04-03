package civil.dpr.application.controller;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.labour.LabourListRequestBody;
import civil.dpr.application.dto.machinery.MachineryListRequestBody;
import civil.dpr.application.transformer.ResponseEntityTransformer;
import civil.dpr.application.transport.machinery.MachineryListTransformer;
import civil.dpr.domain.dto.labour.LabourListResponse;
import civil.dpr.domain.dto.machinery.MachineryListResponse;
import civil.dpr.domain.exception.DomainException;
import civil.dpr.domain.service.MachineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("${base-url.context}/machinery")
@CrossOrigin(origins = "*")
public class MachineryController extends BaseController{

    @Autowired
    private MachineryService machineryService;
    @Autowired
    private ResponseEntityTransformer responseEntityTransformer;
    @Autowired
    private MachineryListTransformer machineryListTransformer;

    @PostMapping(value = "/list")
    public ResponseEntity<Object> getMachineryList(Request<MachineryListRequestBody> request) throws DomainException {

        MachineryListResponse machineryListResponse = machineryService.getMachineryList(request);
        Map<String, Object> trResponse = responseEntityTransformer.transform(machineryListResponse, machineryListTransformer);
        return getResponseEntity(machineryListResponse.getResponseHeader().getResponseCode(), trResponse);

    }

}
