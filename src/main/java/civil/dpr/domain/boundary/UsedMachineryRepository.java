package civil.dpr.domain.boundary;

import civil.dpr.domain.dto.workSummary.list.UsedMachineryDto;
import civil.dpr.domain.entities.UsedMachineryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsedMachineryRepository extends JpaRepository<UsedMachineryEntity, Long> {

    @Query("SELECT NEW civil.dpr.domain.dto.workSummary.list.UsedMachineryDto(" +
            "umc.usedMachineryId, " +
            "umc.machineryEntityId.machineryType, " +
            "umc.machineryEntityId.uom, " +
            "umc.usedQuantity) " +
            "FROM UsedMachineryEntity umc " +
            "WHERE umc.workSummaryEntityId.workSummaryId = :workSummaryId " +
            "AND (umc.recordExpiryDate IS NULL OR umc.recordExpiryDate >= :currentDateTime)")
    List<UsedMachineryDto> findUsedMachineryForWorkSummary(@Param("workSummaryId")Long workSummaryId, @Param("currentDateTime") LocalDateTime currentDateTime);
}
