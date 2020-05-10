package com.sandbox.hibernate.dao;

import com.sandbox.hibernate.models.employee.Employee;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
public interface EmployeeDAO {

    List<Employee> getAll();

    void insertEmployee(Employee employee);
}
