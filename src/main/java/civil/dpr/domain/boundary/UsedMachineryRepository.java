package civil.dpr.domain.boundary;

import civil.dpr.domain.entities.UsedMachineryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsedMachineryRepository extends JpaRepository<UsedMachineryEntity, Long> {
}
