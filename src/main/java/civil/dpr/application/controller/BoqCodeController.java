package civil.dpr.application.controller;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.boqCode.BoqCodeListRequestBody;
import civil.dpr.application.transformer.ResponseEntityTransformer;
import civil.dpr.application.transport.boqCode.BoqCodeListTransformer;
import civil.dpr.domain.dto.boqCode.BoqCodeListResponse;
import civil.dpr.domain.exception.DomainException;
import civil.dpr.domain.service.BoqCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("${base-url.context}/boq-code")
@CrossOrigin(origins = "*")
public class BoqCodeController extends BaseController{

    @Autowired
    private BoqCodeService boqCodeService;
    @Autowired
    private ResponseEntityTransformer responseEntityTransformer;
    @Autowired
    private BoqCodeListTransformer boqCodeListTransformer;

    @PostMapping(value = "/list")
    public ResponseEntity<Object> getBoqCodeList(Request<BoqCodeListRequestBody> request) throws DomainException {

        BoqCodeListResponse boqCodeListResponse = boqCodeService.getBoqCodeList(request);
        Map<String, Object> trResponse = responseEntityTransformer.transform(boqCodeListResponse, boqCodeListTransformer);
        return getResponseEntity(boqCodeListResponse.getResponseHeader().getResponseCode(), trResponse);

    }

}
