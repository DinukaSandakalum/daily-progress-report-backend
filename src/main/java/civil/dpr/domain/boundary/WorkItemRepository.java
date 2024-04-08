package civil.dpr.domain.boundary;

import civil.dpr.domain.dto.workItem.WorkItemDetail;
import civil.dpr.domain.entities.WorkItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WorkItemRepository extends JpaRepository<WorkItemEntity, Long> {

    @Query("SELECT w FROM WorkItemEntity w WHERE w.workItemId = :workItemId " +
            "AND (w.recordExpiryDate IS NULL OR w.recordExpiryDate >= :currentDateTime)")
    WorkItemEntity workItemDetailsById(Long workItemId, LocalDateTime currentDateTime);

    @Query("SELECT NEW civil.dpr.domain.dto.workItem.WorkItemDetail(" +
            "w.workItemId, " +
            "w.workDescription, " +
            "w.plannedStartDate, " +
            "w.plannedEndDate " +
            ") " +
            "FROM WorkItemEntity w " +
            "WHERE (w.recordExpiryDate IS NULL OR w.recordExpiryDate >= :currentDateTime)")
    List<WorkItemDetail> findAllWorkItemDetails(@Param("currentDateTime") LocalDateTime currentDateTime);
}
