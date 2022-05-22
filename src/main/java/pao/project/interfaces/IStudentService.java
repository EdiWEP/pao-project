package pao.project.interfaces;

import pao.project.entities.Course;
import pao.project.entities.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {

    int getNumberOfGrades(Long id);

    float getAverageGradeById(Long id);

    float getAverageGradeByIdInCourse(Long id, Course course);

    Map<Student, Float> getAllAverageGrades();

    List<Student> getStudentsWithGradesLowerThan(int grade);

    Student getStudent(Long id);

    void deleteStudent(Long id);

    void updateStudent(Student student);

    void saveStudent(Student department);

    void saveStudents(List<Student> students);
}
