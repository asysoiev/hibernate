package com.sandbox.hibernate.dao.em;

import com.sandbox.hibernate.dao.EmployeeDAO;
import com.sandbox.hibernate.models.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Andrii Sysoiev
 */
@Profile("JpaEM")
@Repository
public class EmployeeEmDAO implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);
        return query.getResultList();
    }

    @Override
    public void insertEmployee(Employee employee) {
        entityManager.persist(employee);
    }
}
