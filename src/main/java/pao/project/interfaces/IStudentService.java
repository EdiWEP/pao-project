package pao.project.interfaces;

import pao.project.entities.Course;
import pao.project.entities.Student;

import java.util.List;

public interface IStudentService {

    Student getStudent(Long id);

    void deleteStudent(Long id);

    void updateStudent(Student student);

    void saveStudent(Student department);

    void saveStudents(List<Student> students);
}
