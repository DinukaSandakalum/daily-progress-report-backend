package civil.dpr.domain.boundary;

import civil.dpr.domain.dto.machinery.MachineryDetail;
import civil.dpr.domain.entities.MachineryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MachineryRepository extends JpaRepository<MachineryEntity, Long> {

    @Query("SELECT NEW civil.dpr.domain.dto.machinery.MachineryDetail(" +
            "m.machineryId, " +
            "m.machineryType, " +
            "m.uom, " +
            "m.machineryRate " +
            ") " +
            "FROM MachineryEntity m " +
            "WHERE (m.recordExpiryDate IS NULL OR m.recordExpiryDate >= :currentDateTime)")
    List<MachineryDetail> findAllMachineryDetails(@Param("currentDateTime") LocalDateTime currentDateTime);

}
