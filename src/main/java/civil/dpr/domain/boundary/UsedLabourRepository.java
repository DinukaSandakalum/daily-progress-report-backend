package civil.dpr.domain.boundary;

import civil.dpr.domain.dto.workSummary.list.UsedLabourDto;
import civil.dpr.domain.entities.UsedLabourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsedLabourRepository extends JpaRepository<UsedLabourEntity, Long> {

    @Query("SELECT NEW civil.dpr.domain.dto.workSummary.list.UsedLabourDto(" +
            "ul.usedLabourId, " +
            "ul.labourEntityId.labourType, " +
            "ul.usedQuantity) " +
            "FROM UsedLabourEntity ul " +
            "WHERE ul.workSummaryEntityId.workSummaryId = :workSummaryId " +
            "AND (ul.recordExpiryDate IS NULL OR ul.recordExpiryDate >= :currentDateTime)")
    List<UsedLabourDto> findUsedLabourForWorkSummary(@Param("workSummaryId")Long workSummaryId, @Param("currentDateTime") LocalDateTime currentDateTime);
}
