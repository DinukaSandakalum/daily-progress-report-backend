package civil.dpr.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "labour")
public class LabourEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LabourId")
    private Long labourId;
    @Column(name = "LabourType")
    private String labourType;
    @Column(name = "LabourRate")
    private BigDecimal labourRate;

}
