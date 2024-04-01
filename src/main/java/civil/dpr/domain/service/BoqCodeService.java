package civil.dpr.domain.service;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.boqCode.BoqCodeListRequestBody;
import civil.dpr.domain.boundary.BoqCodeRepository;
import civil.dpr.domain.dto.boqCode.BoqCodeDetail;
import civil.dpr.domain.dto.boqCode.BoqCodeListResponse;
import civil.dpr.domain.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoqCodeService implements CommonService {

    @Autowired
    private BoqCodeRepository boqCodeRepository;

    public BoqCodeListResponse getBoqCodeList(Request<BoqCodeListRequestBody> request) throws DomainException {

        try {
            List<BoqCodeDetail> boqCodeDetailList = boqCodeRepository.findAllBoqDetails(LocalDateTime.now());
            return new BoqCodeListResponse(boqCodeDetailList, createResponseHeader(request.getRequestHeader()));
        } catch (Exception e) {
            throw new DomainException("error occurred", "");
        }

    }

}
