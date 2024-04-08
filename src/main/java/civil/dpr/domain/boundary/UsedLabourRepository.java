package civil.dpr.domain.boundary;

import civil.dpr.domain.entities.UsedLabourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsedLabourRepository extends JpaRepository<UsedLabourEntity, Long> {
}
