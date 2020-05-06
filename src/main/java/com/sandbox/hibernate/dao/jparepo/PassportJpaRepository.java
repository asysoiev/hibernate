package com.sandbox.hibernate.dao.jparepo;

import com.sandbox.hibernate.models.Passport;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Andrii Sysoiev
 */
@Profile("JpaRepo")
@Repository
public interface PassportJpaRepository extends JpaRepository<Passport, Long> {

}
