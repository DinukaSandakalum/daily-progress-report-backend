package civil.dpr.domain.boundary;

import civil.dpr.domain.dto.workSummary.list.WorkSummaryBasicDto;
import civil.dpr.domain.dto.workSummary.list.WorkSummaryDto;
import civil.dpr.domain.dto.workSummary.list.WorkSummaryListResponse;
import civil.dpr.domain.entities.WorkSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WorkSummaryRepository extends JpaRepository<WorkSummaryEntity, Long> {

    @Query("SELECT NEW civil.dpr.domain.dto.workSummary.list.WorkSummaryBasicDto(" +
                "ws.workSummaryId, " +
                "ws.workItemEntityId.workDescription, " +
                "ws.workDate, " +
                "ws.completedQuantity, " +
                "ws.boqCodeEntityId.boqCode, " +
                "ws.boqCodeEntityId.boqDescription, " +
                "ws.userEntityId.userName, " +
                "ws.approvalStatus" +
            ") " +
            "FROM WorkSummaryEntity ws " +
            "WHERE (:workSummaryId IS NULL OR ws.workSummaryId = :workSummaryId) " +
            "AND (:workItemId IS NULL OR ws.workItemEntityId.workItemId = :workItemId) " +
            "AND (:userId IS NULL OR ws.userEntityId.userId = :userId) " +
            "AND (ws.recordExpiryDate IS NULL OR ws.recordExpiryDate >= :currentDateTime) ")
    List<WorkSummaryBasicDto> getWorkSummaryList(@Param("workSummaryId") Long workSummaryId, @Param("workItemId") Long workItemId,
                                                 @Param("userId") Long userId, @Param("currentDateTime") LocalDateTime currentDateTime);

    @Query("SELECT ws FROM WorkSummaryEntity ws " +
            "WHERE (:workSummaryId IS NULL OR ws.workSummaryId = :workSummaryId) " +
            "AND (ws.recordExpiryDate IS NULL OR ws.recordExpiryDate >= :currentDateTime) ")
    WorkSummaryEntity findByWorkSummaryId(@Param("workSummaryId") Long workSummaryId, @Param("currentDateTime") LocalDateTime currentDateTime);
}
