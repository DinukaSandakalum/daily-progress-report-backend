package civil.dpr.domain.service;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.machinery.MachineryListRequestBody;
import civil.dpr.domain.boundary.MachineryRepository;
import civil.dpr.domain.dto.machinery.MachineryDetail;
import civil.dpr.domain.dto.machinery.MachineryListResponse;
import civil.dpr.domain.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MachineryService implements CommonService{

    @Autowired
    private MachineryRepository machineryRepository;

    public MachineryListResponse getMachineryList(Request<MachineryListRequestBody> request) throws DomainException {

        try {
            List<MachineryDetail> machineryDetailList = machineryRepository.findAllMachineryDetails(LocalDateTime.now());
            return new MachineryListResponse(machineryDetailList, createResponseHeader(request.getRequestHeader()));
        } catch (Exception e) {
            throw new DomainException("error occurred", "");
        }

    }

}
