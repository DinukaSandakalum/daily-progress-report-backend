package civil.dpr.domain.boundary;

import civil.dpr.domain.dto.user.UserDetail;
import civil.dpr.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT NEW civil.dpr.domain.dto.user.UserDetail(" +
            "u.userId, " +
            "u.userName, " +
            "u.userRole " +
            ") " +
            "FROM UserEntity u " +
            "WHERE ( :un = null OR u.userName = :un) " +
            "AND ( :pw = null OR u.password = :pw) " +
            "AND (u.recordExpiryDate IS NULL OR u.recordExpiryDate >= :currentDateTime)")
    UserDetail findUserByNameAndPassword(@Param("un") String userName, @Param("pw") String password, @Param("currentDateTime") LocalDateTime currentDateTime);

    @Query("SELECT u FROM UserEntity u WHERE u.userId = :userId " +
            "AND (u.recordExpiryDate IS NULL OR u.recordExpiryDate >= :currentDateTime)")
    UserEntity userDeatailsById(Long userId, LocalDateTime currentDateTime);
}
