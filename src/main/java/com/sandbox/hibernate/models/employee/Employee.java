package com.sandbox.hibernate.models.employee;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.SequenceGenerator;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

/**
 * @author Andrii Sysoiev
 */
@Entity
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "EMPLOYEE_TYPE")
public abstract class Employee {

    @Id
    @SequenceGenerator(name = "employee_seq", allocationSize = 1, initialValue = 60000)
    @GeneratedValue(generator = "employee_seq")
    private Long id;
    private String name;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

}
