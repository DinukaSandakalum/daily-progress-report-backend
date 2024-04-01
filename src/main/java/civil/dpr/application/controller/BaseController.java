
package civil.dpr.application.controller;

import civil.dpr.application.config.YAMLConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.jboss.logging.MDC;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class.getName());

    @Autowired
    private YAMLConfig yamlConfig;

    public void setLogIdentifier(HttpServletRequest request) {

        String logIdentifier = request.getHeader(yamlConfig.getLogIdentifierKey());
        if (logIdentifier != null) {
            MDC.put(yamlConfig.getLogIdentifierKey(), logIdentifier);
        } else {
            MDC.put(yamlConfig.getLogIdentifierKey(), UUID.randomUUID().toString());
        }
    }

    public ResponseEntity<Object> getResponseEntity(String responseCode, Object trResponse) {
        switch (responseCode) {
            case "200":
                return ResponseEntity.status(HttpStatus.OK).body(trResponse);
            case "201":
                return ResponseEntity.status(HttpStatus.CREATED).body(trResponse);
            case "202":
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(trResponse);
            case "400":
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(trResponse);
            case "401":
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(trResponse);
            case "404":
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(trResponse);
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(trResponse);
        }
    }
}
