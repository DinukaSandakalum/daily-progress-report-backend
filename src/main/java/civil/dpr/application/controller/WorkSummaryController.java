package civil.dpr.application.controller;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.workSummary.create.WorkSummaryCreateRequestBody;
import civil.dpr.application.dto.workSummary.get.WorkSummaryGetRequestBody;
import civil.dpr.application.dto.workSummary.update.WorkSummaryStatusUpdateRequestBody;
import civil.dpr.application.transformer.ResponseEntityTransformer;
import civil.dpr.application.transport.workSummary.WorkSummaryCreateTransformer;
import civil.dpr.application.transport.workSummary.WorkSummaryListTransformer;
import civil.dpr.application.transport.workSummary.WorkSummaryStatusUpdateTransformer;
import civil.dpr.domain.dto.workSummary.create.WorkSummaryCreateResponse;
import civil.dpr.domain.dto.workSummary.list.WorkSummaryListResponse;
import civil.dpr.domain.dto.workSummary.statusUpdate.WorkSummaryStatusUpdateResponse;
import civil.dpr.domain.exception.DomainException;
import civil.dpr.domain.service.WorkSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private WorkSummaryListTransformer workSummaryListTransformer;
    @Autowired
    private WorkSummaryStatusUpdateTransformer workSummaryStatusUpdateTransformer;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createWorkSummary(@Validated @RequestBody Request<WorkSummaryCreateRequestBody> request) throws DomainException {

        WorkSummaryCreateResponse workSummaryCreateResponse = workSummaryService.createWorkSummary(request);
        Map<String, Object> trResponse = responseEntityTransformer.transform(workSummaryCreateResponse, workSummaryCreateTransformer);
        return getResponseEntity(workSummaryCreateResponse.getResponseHeader().getResponseCode(), trResponse);

    }

    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getWorkSummary(@Validated @RequestBody Request<WorkSummaryGetRequestBody> request) throws DomainException {

        WorkSummaryListResponse workSummaryListResponse = workSummaryService.listWorkSummary(request);
        Map<String, Object> trResponse = responseEntityTransformer.transform(workSummaryListResponse, workSummaryListTransformer);
        return getResponseEntity(workSummaryListResponse.getResponseHeader().getResponseCode(), trResponse);

    }

    @PostMapping(value = "/status/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> statusUpdateOfWorkSummary(@Validated @RequestBody Request<WorkSummaryStatusUpdateRequestBody> request) throws DomainException {

        WorkSummaryStatusUpdateResponse workSummaryStatusUpdateResponse = workSummaryService.updateStatusOfWorkSummary(request);
        Map<String, Object> trResponse = responseEntityTransformer.transform(workSummaryStatusUpdateResponse, workSummaryStatusUpdateTransformer);
        return getResponseEntity(workSummaryStatusUpdateResponse.getResponseHeader().getResponseCode(), trResponse);

    }

}
