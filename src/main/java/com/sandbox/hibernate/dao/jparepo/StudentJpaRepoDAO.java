package com.sandbox.hibernate.dao.jparepo;

import com.sandbox.hibernate.dao.StudentDAO;
import com.sandbox.hibernate.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrii Sysoiev
 */
@Profile("JpaRepo")
@Repository
public class StudentJpaRepoDAO implements StudentDAO {

    @Autowired
    private StudentJpaRepository studentJpaRepository;

    @Override
    public Optional<Student> findById(Long id) {
        return studentJpaRepository.findById(id);
    }

    @Override
    public List<Student> findByPassportNumber(String pattern) {
        return studentJpaRepository.findByPassportNumberContains(pattern);
    }

    @Override
    public Student insert(Student student) {
        return studentJpaRepository.save(student);
    }
}
