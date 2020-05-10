package com.sandbox.hibernate.services;

import com.sandbox.hibernate.models.employee.Employee;
import com.sandbox.hibernate.models.employee.FullTimeEmployee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.util.List;

import static com.sandbox.hibernate.services.EmployeeServiceTest.EmployeeType.Full;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.jdbc.JdbcTestUtils.countRowsInTableWhere;

/**
 * @author Andrii Sysoiev
 */
public abstract class EmployeeServiceTest extends BaseServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testGetAll() {
        List<Employee> all = employeeService.getAll();
        assertNotNull(all);
        assertEquals(2, all.size());
    }

    @DirtiesContext
    @Test
    void testCreateFullTimeEmployee() {
        int count = getRecordsCount(Full);
        assertEquals(1, count);

        FullTimeEmployee employee = new FullTimeEmployee();
        employee.setName("Ivan Mazepa");
        employee.setSalary(BigDecimal.valueOf(2000.0));
        employeeService.create(employee);

        count = getRecordsCount(Full);
        assertEquals(2, count);
    }

    private int getRecordsCount(EmployeeType type) {
        switch (type) {
            case Full:
                return countRowsInTableWhere(jdbcTemplate, "employee", "employee_type='FULL_TIME'");
            case Part:
                return countRowsInTableWhere(jdbcTemplate, "employee", "employee_type='PART_TIME'");
            default:
                throw new UnsupportedOperationException();
        }
    }

    public enum EmployeeType {
        Full, Part
    }
}
