package civil.dpr.domain.service;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.user.UserDetailRequestBody;
import civil.dpr.domain.boundary.UserRepository;
import civil.dpr.domain.dto.user.UserDetail;
import civil.dpr.domain.dto.user.UserDetailResponse;
import civil.dpr.domain.entities.UserEntity;
import civil.dpr.domain.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService implements CommonService{

    @Autowired
    private UserRepository userRepository;

    public UserDetailResponse getUserDetails(Request<UserDetailRequestBody> request) throws DomainException {

        try {
            UserDetail userDetail = userRepository.findUserByNameAndPassword(
                    request.getRequestBody().getUserName(),
                    request.getRequestBody().getPassword(),
                    LocalDateTime.now());
            return new UserDetailResponse(userDetail, createResponseHeader(request.getRequestHeader()));
        } catch (Exception e) {
            throw new DomainException("error occurred", "");
        }

    }

}
