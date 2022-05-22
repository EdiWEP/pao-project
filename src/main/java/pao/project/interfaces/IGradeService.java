package pao.project.interfaces;

import pao.project.entities.Course;
import pao.project.entities.Grade;
import pao.project.entities.Teacher;

import java.util.List;

public interface IGradeService {

    List<Grade> getGradesGivenThisMonth();

    Grade getGrade(Long id);

    void deleteGrade(Long id);

    void updateGrade(Grade student);

    void saveGrade(Grade grade);

    void saveGrades(List<Grade> grades);
}
