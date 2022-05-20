package pao.project.interfaces;


import pao.project.entities.Teacher;

public interface ITeacherService {


    Teacher getTeacher(Long id);

    void deleteTeacher(Long id);

    void updateTeacher(Teacher student);

    void saveTeacher(Teacher teacher);
}
