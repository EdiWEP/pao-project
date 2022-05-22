package pao.project.interfaces;

import pao.project.entities.Course;
import pao.project.entities.Student;
import pao.project.entities.Teacher;

import java.util.List;

public interface ICourseService {

    float getPercentageOfGradesAbove(Long id, int grade);

    List<Student> getStudentsWithoutGrades(Long id);

    Course getCourseWithHighestCredits();

    int getTotalCredits();

    float getAverageGradeInCourse(Long id);

    Course getCourse(Long id);

    void deleteCourse(Long id);

    void updateCourse(Course student);

    void saveCourse(Course course);

    void saveCourses(List<Course> courses);

}
