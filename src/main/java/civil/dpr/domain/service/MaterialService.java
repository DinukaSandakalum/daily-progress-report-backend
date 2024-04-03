package civil.dpr.domain.service;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.material.MaterialListRequestBody;
import civil.dpr.domain.boundary.MaterialRepository;
import civil.dpr.domain.dto.material.MaterialDetail;
import civil.dpr.domain.dto.material.MaterialListResponse;
import civil.dpr.domain.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MaterialService implements CommonService{

    @Autowired
    private MaterialRepository materialRepository;

    public MaterialListResponse getMaterialList(Request<MaterialListRequestBody> request) throws DomainException {

        try {
            List<MaterialDetail> materialDetailList = materialRepository.findAllMaterialDetails(LocalDateTime.now());
            return new MaterialListResponse(materialDetailList, createResponseHeader(request.getRequestHeader()));
        } catch (Exception e) {
            throw new DomainException("error occurred", "");
        }

    }

}
