package civil.dpr.application.controller;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.user.UserDetailRequestBody;
import civil.dpr.application.transformer.ResponseEntityTransformer;
import civil.dpr.application.transport.user.UserDetailTransformer;
import civil.dpr.domain.dto.user.UserDetailResponse;
import civil.dpr.domain.exception.DomainException;
import civil.dpr.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("${base-url.context}/user")
@CrossOrigin(origins = "*")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private ResponseEntityTransformer responseEntityTransformer;
    @Autowired
    private UserDetailTransformer userDetailTransformer;

    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUserDetail(@Validated @RequestBody Request <UserDetailRequestBody> request) throws DomainException {

        UserDetailResponse userDetailResponse = userService.getUserDetails(request);
        Map<String, Object> trResponse = responseEntityTransformer.transform(userDetailResponse, userDetailTransformer);
        return getResponseEntity(userDetailResponse.getResponseHeader().getResponseCode(), trResponse);

    }

}
