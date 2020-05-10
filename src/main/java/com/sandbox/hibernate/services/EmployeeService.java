package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.employee.Employee;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
public interface EmployeeService {

    List<Employee> getAll();

    void create(Employee employee);

}
