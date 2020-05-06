package com.sandbox.hibernate.dao.em;

import com.sandbox.hibernate.dao.StudentDAO;
import com.sandbox.hibernate.models.Student;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Andrii Sysoiev
 */
@Profile("JpaEM")
@Repository
public class StudentJpaEmDAO implements StudentDAO {
    @Override
    public Student insert(Student student) {
        throw new UnsupportedOperationException("Not implemented.");
    }
}
