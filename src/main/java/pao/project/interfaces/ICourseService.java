package pao.project.interfaces;

import pao.project.entities.Course;
import pao.project.entities.Teacher;

public interface ICourseService {

    Course getCourse(Long id);

    void deleteCourse(Long id);

    void updateCourse(Course student);

    void saveCourse(Course course);

}
