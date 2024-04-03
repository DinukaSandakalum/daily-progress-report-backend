package civil.dpr.domain.service;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.labour.LabourListRequestBody;
import civil.dpr.domain.boundary.LabourRepository;
import civil.dpr.domain.dto.labour.LabourDetail;
import civil.dpr.domain.dto.labour.LabourListResponse;
import civil.dpr.domain.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LabourService implements CommonService{

    @Autowired
    private LabourRepository labourRepository;

    public LabourListResponse getLabourList(Request<LabourListRequestBody> request) throws DomainException {

        try {
            List<LabourDetail> labourDetailList = labourRepository.findAllLabourDetails(LocalDateTime.now());
            return new LabourListResponse(labourDetailList, createResponseHeader(request.getRequestHeader()));
        } catch (Exception e) {
            throw new DomainException("error occurred", "");
        }

    }

}
