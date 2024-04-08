package civil.dpr.domain.boundary;

import civil.dpr.domain.entities.WorkSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkSummaryRepository extends JpaRepository<WorkSummaryEntity, Long> {
}
