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
@Table(name = "boqcode")
public class BoqCodeEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BoqId")
    private Long boqId;
    @Column(name = "BoqCode")
    private String boqCode;
    @Column(name = "BoqDescription")
    private String boqDescription;
    @Column(name = "Rate")
    private BigDecimal rate;
    @Column(name = "Uom")
    private String uom;

}
