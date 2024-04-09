package civil.dpr.domain.boundary;

import civil.dpr.domain.dto.workSummary.list.UsedMaterialDto;
import civil.dpr.domain.entities.UsedMaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsedMaterialRepository extends JpaRepository<UsedMaterialEntity, Long> {

    @Query("SELECT NEW civil.dpr.domain.dto.workSummary.list.UsedMaterialDto(" +
            "umt.usedMaterialId, " +
            "umt.materialEntityId.materialName, " +
            "umt.materialEntityId.uom, " +
            "umt.usedQuantity) " +
            "FROM UsedMaterialEntity umt " +
            "WHERE umt.workSummaryEntityId.workSummaryId = :workSummaryId " +
            "AND (umt.recordExpiryDate IS NULL OR umt.recordExpiryDate >= :currentDateTime)")
    List<UsedMaterialDto> findUsedMaterialsForWorkSummary(@Param("workSummaryId")Long workSummaryId, @Param("currentDateTime") LocalDateTime currentDateTime);
}
