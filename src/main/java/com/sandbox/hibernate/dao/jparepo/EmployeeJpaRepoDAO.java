package com.sandbox.hibernate.dao.jparepo;

import com.sandbox.hibernate.dao.EmployeeDAO;
import com.sandbox.hibernate.models.employee.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
@Profile("JpaRepo")
@Repository
public class EmployeeJpaRepoDAO implements EmployeeDAO {
    @Override
    public List<Employee> getAll() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override
    public void insertEmployee(Employee employee) {
        throw new UnsupportedOperationException("Not implemented.");
    }
}
