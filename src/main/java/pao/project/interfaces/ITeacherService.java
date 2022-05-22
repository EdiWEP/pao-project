package pao.project.interfaces;


import pao.project.entities.Course;
import pao.project.entities.Teacher;

import java.util.List;

public interface ITeacherService {


    int getNumberOfTaughtCourses(Long id);

    Teacher getTeacher(Long id);

    void deleteTeacher(Long id);

    void updateTeacher(Teacher student);

    void saveTeacher(Teacher teacher);

    void saveTeachers(List<Teacher> teachers);
}
