package civil.dpr.application.controller;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.workSummary.create.WorkSummaryCreateDetail;
import civil.dpr.application.dto.workSummary.create.WorkSummaryCreateRequestBody;
import civil.dpr.application.transformer.ResponseEntityTransformer;
import civil.dpr.application.transport.workSummary.WorkSummaryCreateTransformer;
import civil.dpr.domain.dto.user.UserDetailResponse;
import civil.dpr.domain.dto.workSummary.WorkSummaryCreateResponse;
import civil.dpr.domain.exception.DomainException;
import civil.dpr.domain.service.WorkSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("${base-url.context}/worksummary")
@CrossOrigin(origins = "*")
public class WorkSummaryController extends BaseController{

    @Autowired
    private WorkSummaryService workSummaryService;
    @Autowired
    private ResponseEntityTransformer responseEntityTransformer;
    @Autowired
    private WorkSummaryCreateTransformer workSummaryCreateTransformer;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createWorkSummary(@Validated @RequestBody Request<WorkSummaryCreateRequestBody> request) throws DomainException {

        WorkSummaryCreateResponse workSummaryCreateResponse = workSummaryService.createWorkSummary(request);
        Map<String, Object> trResponse = responseEntityTransformer.transform(workSummaryCreateResponse, workSummaryCreateTransformer);
        return getResponseEntity(workSummaryCreateResponse.getResponseHeader().getResponseCode(), trResponse);

    }

}
