
package civil.dpr.domain.util;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum DomainErrorCode {
    SUCCESS("CMS1000", "Success", HttpStatus.OK);
    private final String code;
    private final String description;
    private final HttpStatus httpStatus;

    DomainErrorCode(String code, String description, HttpStatus httpStatus) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
