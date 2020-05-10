package com.sandbox.hibernate.models.employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author Andrii Sysoiev
 */
@Entity
@DiscriminatorValue("PART_TIME")
public class PartTimeEmployee extends Employee {

    private BigDecimal hourlyWage;

    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }

    public PartTimeEmployee setHourlyWage(BigDecimal hourlyWage) {
        this.hourlyWage = hourlyWage;
        return this;
    }
}
