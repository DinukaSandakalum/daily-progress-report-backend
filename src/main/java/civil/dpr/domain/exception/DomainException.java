/**
 * Copyrights 2020 Axiata Digital Labs Pvt Ltd.
 * All Rights Reserved.
 *
 * These material are unpublished, proprietary, confidential source
 * code of Axiata Digital Labs Pvt Ltd (ADL) and constitute a TRADE
 * SECRET of ADL.
 *
 * ADL retains all title to and intellectual property rights in these
 * materials.
 *
 */
package civil.dpr.domain.exception;

import civil.dpr.application.exception.type.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DomainException extends BaseException {
    private String requestId;

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, String code) {
        super(message, code);
    }
    public DomainException(String message, String code, Throwable e) {
        super(message, code, e);
    }

    public DomainException(String message, Throwable e) {
        super(message, e);
    }

    public String getRequestId() {
        return requestId;
    }
}
