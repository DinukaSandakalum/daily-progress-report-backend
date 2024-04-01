package civil.dpr.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity {

    private static final String SYSTEM_USER = "SystemUser";

    @CreationTimestamp
    @Column(name = "CreatedDate", updatable = false, nullable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "LastUpdatedDate", nullable = false)
    private LocalDateTime lastUpdatedDate;

    @Column(name = "RecordExpiryDate")
    private LocalDateTime recordExpiryDate;

    @Column(name = "CreatedBy", columnDefinition = "VARCHAR(255) DEFAULT 'SystemUser'")
    private String createdBy = SYSTEM_USER;

    @Column(name = "UpdatedBy", columnDefinition = "VARCHAR(255) DEFAULT 'SystemUser'")
    private String updatedBy = SYSTEM_USER;

    @PreUpdate
    public void preUpdate() {
        if (updatedBy == null) {
            updatedBy = SYSTEM_USER;
        }
    }
}