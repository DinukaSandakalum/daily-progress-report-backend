/**
 * Copyrights 2023 Axiata Digital Labs Pvt Ltd.
 * All Rights Reserved.
 *
 * These material are unpublished, proprietary, confidential source
 * code of Axiata Digital Labs Pvt Ltd (ADL) and constitute a TRADE
 * SECRET of ADL.
 *
 * ADL retains all title to and intellectual property rights in these
 * materials.
 */
package civil.dpr.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is the pagination class
 *
 * @author Malmitha Baranasuriya
 * @version 1.0
 * @since 2023.11.16
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pagination {
    private int totalCount;
    private int pageNo;

    // Constructor
    // Getters and Setters
    // ...
}
