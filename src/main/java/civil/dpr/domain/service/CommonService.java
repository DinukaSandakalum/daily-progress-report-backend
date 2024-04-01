package civil.dpr.domain.service;

import civil.dpr.application.dto.RequestHeader;
import civil.dpr.domain.dto.ResponseHeader;
import civil.dpr.domain.util.DomainErrorCode;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public interface CommonService {
    default ResponseHeader createResponseHeader(RequestHeader requestHeader, String responseDescription) {
        ResponseHeader responseHeader = new ResponseHeader();
        if ( Objects.nonNull(requestHeader) ) {
            responseHeader.setRequestId(requestHeader.getRequestId());
        }
        responseHeader.setResponseCode(String.valueOf(HttpStatus.OK.value()));
        responseHeader.setCode(DomainErrorCode.SUCCESS.getCode());
        responseHeader.setDesc(responseDescription);
        responseHeader.setTimestamp(LocalDateTime.now().toString());
        return responseHeader;
    }

    /**
     * This method is responsible for creating response header
     * when code is CMS1000 and desc is Success
     * @param requestHeader requestHeader
     * @return ResponseHeader
     */
    default  ResponseHeader createResponseHeader(RequestHeader requestHeader) {
        ResponseHeader responseHeader = new ResponseHeader();
        if ( Objects.nonNull(requestHeader) ) {
            responseHeader.setRequestId(requestHeader.getRequestId());
        }
        responseHeader.setTimestamp(LocalDateTime.now().toString());
        responseHeader.setCode(DomainErrorCode.SUCCESS.getCode());
        responseHeader.setDesc(DomainErrorCode.SUCCESS.getDescription());
        responseHeader.setResponseCode(String.valueOf(HttpStatus.OK.value()));
        return responseHeader;
    }


}
