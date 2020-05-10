package com.sandbox.hibernate.services;

import com.sandbox.hibernate.dao.EmployeeDAO;
import com.sandbox.hibernate.models.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Transactional
    @Override
    public void create(Employee employee) {
        employeeDAO.insertEmployee(employee);
    }
}
