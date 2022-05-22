package pao.project.interfaces;

import pao.project.entities.Course;
import pao.project.entities.Teacher;

import java.util.List;

public interface ICourseService {

    float getAverageGradeInCourse(Long id);

    Course getCourse(Long id);

    void deleteCourse(Long id);

    void updateCourse(Course student);

    void saveCourse(Course course);

    void saveCourses(List<Course> courses);

}
