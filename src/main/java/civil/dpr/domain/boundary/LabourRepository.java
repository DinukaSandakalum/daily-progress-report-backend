package civil.dpr.domain.boundary;

import civil.dpr.domain.dto.labour.LabourDetail;
import civil.dpr.domain.entities.LabourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LabourRepository extends JpaRepository<LabourEntity, Long> {

    @Query("SELECT NEW civil.dpr.domain.dto.labour.LabourDetail(" +
            "l.labourId, " +
            "l.labourType, " +
            "l.labourRate " +
            ") " +
            "FROM LabourEntity l " +
            "WHERE (l.recordExpiryDate IS NULL OR l.recordExpiryDate >= :currentDateTime)")
    List<LabourDetail> findAllLabourDetails(@Param("currentDateTime") LocalDateTime currentDateTime);

}
