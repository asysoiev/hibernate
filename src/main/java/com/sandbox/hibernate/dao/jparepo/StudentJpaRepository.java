package com.sandbox.hibernate.dao.jparepo;

import com.sandbox.hibernate.models.Student;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Andrii Sysoiev
 */
@Profile("JpaRepo")
@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Long> {
}
