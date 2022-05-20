package pao.project.interfaces;

import pao.project.entities.Student;

public interface IStudentService {

    Student getStudent(Long id);

    void deleteStudent(Long id);

    void updateStudent(Student student);

    void saveStudent(Student department);

}
