package civil.dpr.domain.boundary;

import civil.dpr.domain.dto.material.MaterialDetail;
import civil.dpr.domain.entities.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {

    @Query("SELECT NEW civil.dpr.domain.dto.material.MaterialDetail(" +
            "m.materialId, " +
            "m.materialName, " +
            "m.uom, " +
            "m.materialRate " +
            ") " +
            "FROM MaterialEntity m " +
            "WHERE (m.recordExpiryDate IS NULL OR m.recordExpiryDate >= :currentDateTime)")
    List<MaterialDetail> findAllMaterialDetails(@Param("currentDateTime") LocalDateTime currentDateTime);

    @Query("SELECT m FROM MaterialEntity m WHERE m.materialId = :materialId " +
            "AND (m.recordExpiryDate IS NULL OR m.recordExpiryDate >= :currentDateTime)")
    MaterialEntity MaterialDetailsById(Long materialId, LocalDateTime currentDateTime);
}
