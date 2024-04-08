package civil.dpr.application.controller;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.machinery.MachineryListRequestBody;
import civil.dpr.application.dto.workItem.WorkItemListRequestBody;
import civil.dpr.application.transformer.ResponseEntityTransformer;
import civil.dpr.application.transport.workItem.WorkItemTransformer;
import civil.dpr.domain.dto.machinery.MachineryListResponse;
import civil.dpr.domain.dto.workItem.WorkItemDetailResponse;
import civil.dpr.domain.exception.DomainException;
import civil.dpr.domain.service.WorkItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("${base-url.context}/workitem")
@CrossOrigin(origins = "*")
public class WorkItemController extends BaseController{

    @Autowired
    private WorkItemService workItemService;
    @Autowired
    private ResponseEntityTransformer responseEntityTransformer;
    @Autowired
    private WorkItemTransformer workItemTransformer;

    @PostMapping(value = "/list")
    public ResponseEntity<Object> getWorkItemList(Request<WorkItemListRequestBody> request) throws DomainException {

        WorkItemDetailResponse workItemDetailResponse = workItemService.getWorkItemList(request);
        Map<String, Object> trResponse = responseEntityTransformer.transform(workItemDetailResponse, workItemTransformer);
        return getResponseEntity(workItemDetailResponse.getResponseHeader().getResponseCode(), trResponse);

    }

}
