package civil.dpr.domain.boundary;

import civil.dpr.domain.dto.boqCode.BoqCodeDetail;
import civil.dpr.domain.entities.BoqCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BoqCodeRepository extends JpaRepository<BoqCodeEntity, Long> {

    @Query("SELECT NEW civil.dpr.domain.dto.boqCode.BoqCodeDetail(" +
            "bc.boqId, " +
            "bc.boqCode, " +
            "bc.boqDescription, " +
            "bc.rate, " +
            "bc.uom" +
            ") " +
            "FROM BoqCodeEntity bc " +
            "WHERE (bc.recordExpiryDate IS NULL OR bc.recordExpiryDate >= :currentDateTime)")
    List<BoqCodeDetail> findAllBoqDetails(@Param("currentDateTime") LocalDateTime currentDateTime);
}
