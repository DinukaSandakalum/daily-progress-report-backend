package civil.dpr.domain.service;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.workItem.WorkItemListRequestBody;
import civil.dpr.domain.boundary.WorkItemRepository;
import civil.dpr.domain.dto.workItem.WorkItemDetail;
import civil.dpr.domain.dto.workItem.WorkItemDetailResponse;
import civil.dpr.domain.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkItemService implements CommonService{
    @Autowired
    private WorkItemRepository workItemRepository;

    public WorkItemDetailResponse getWorkItemList(Request<WorkItemListRequestBody> request) throws DomainException {

        try {
            List<WorkItemDetail> workItemDetailList = workItemRepository.findAllWorkItemDetails(LocalDateTime.now());
            return new WorkItemDetailResponse(workItemDetailList, createResponseHeader(request.getRequestHeader()));
        } catch (Exception ex){
            throw new DomainException("error occurred", "");
        }
    }
}
