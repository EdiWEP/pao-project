package pao.project.interfaces;

import pao.project.entities.Grade;
import pao.project.entities.Teacher;

public interface IGradeService {

    Grade getGrade(Long id);

    void deleteGrade(Long id);

    void updateGrade(Grade student);

    void saveGrade(Grade grade);
}
