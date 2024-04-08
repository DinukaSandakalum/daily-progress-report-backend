package civil.dpr.domain.boundary;

import civil.dpr.domain.entities.UsedMaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsedMaterialRepository extends JpaRepository<UsedMaterialEntity, Long> {
}
