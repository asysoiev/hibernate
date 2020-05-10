package com.sandbox.hibernate.models.employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author Andrii Sysoiev
 */
@Entity
@DiscriminatorValue("FULL_TIME")
public class FullTimeEmployee extends Employee {

    private BigDecimal salary;

    public BigDecimal getSalary() {
        return salary;
    }

    public FullTimeEmployee setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }
}
