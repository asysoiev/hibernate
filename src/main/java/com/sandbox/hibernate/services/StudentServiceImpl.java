package com.sandbox.hibernate.services;

import com.sandbox.hibernate.dao.StudentDAO;
import com.sandbox.hibernate.exceptions.StudentNotFoundException;
import com.sandbox.hibernate.models.Course;
import com.sandbox.hibernate.models.Passport;
import com.sandbox.hibernate.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrii Sysoiev
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private PassportService passportService;
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private CourseService courseService;

    @Override
    public Student findById(Long id) {
        return studentDAO.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Transactional
    @Override
    public Student createStudent(Student student) {
        Passport passport = student.getPassport();
        if (passport != null) {
            passport = passportService.createPassport(passport);
            student.setPassport(passport);
        }
        List<Course> newCourses = new ArrayList<>();
        List<Course> existedCourses = new ArrayList<>();
        for (Course course : student.getCourses()) {
            if (course.getId() != null) {
                Course existedCourse = courseService.findById(course.getId());
                existedCourses.add(existedCourse);
            } else {
                newCourses.add(course);
            }
        }
        student.removeCourses(existedCourses);

        Student insertedStudent = studentDAO.insert(student);
        for (Course existedCourse : existedCourses) {
            insertedStudent.addCourse(existedCourse);
            existedCourse.getStudents().add(insertedStudent);
            courseService.updateCourse(existedCourse);
        }

        for (Course course : newCourses) {
            course.addStudent(insertedStudent);
            courseService.createCourse(course);
        }
        return insertedStudent;
    }

    @Override
    public List<Student> findByPassportNumber(String pattern) {
        return studentDAO.findByPassportNumber(pattern);
    }
}
