package com.sandbox.hibernate.dao.jparepo;

import com.sandbox.hibernate.dao.CourseDAO;
import com.sandbox.hibernate.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Andrii Sysoiev
 */
@Profile("JpaRepo")
@Repository
public class CourseJpaRepoDAO implements CourseDAO {
    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Override
    public List<Course> getAll() {
        List<Course> result = new ArrayList<>();
        Sort sort = Sort.by("title");
        result.addAll(courseJpaRepository.findAll(sort));
//        PageRequest pageRequest = PageRequest.of(0, 3, sort);
//        Page<Course> page = courseJpaRepository.findAll(pageRequest);
//        result.addAll(page.getContent());
//        while (page.hasNext()){
//            Pageable pageable = page.nextPageable();
//            page = courseJpaRepository.findAll(pageable);
//            result.addAll(page.getContent());
//        }
        return result;
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseJpaRepository.findById(id);
    }

    @Override
    public List<Course> findByTitle(String title) {
        return courseJpaRepository.findByTitleContains(title);
    }

    @Override
    public List<Course> getCoursesWithoutStudents() {
        return courseJpaRepository.getCoursesWithoutStudents();
    }

    @Override
    public List<Course> getCoursesWithAtLeastStudents(int studentsCount) {
        return courseJpaRepository.getCoursesWithAtLeastStudents(studentsCount);
    }

    @Override
    public Course insert(Course course) {
        return courseJpaRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return courseJpaRepository.save(course);
    }

    @Override
    public void delete(Course course) {
        courseJpaRepository.delete(course);
    }
}
