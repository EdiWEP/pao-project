package pao.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pao.project.CsvLogger;
import pao.project.entities.Grade;
import pao.project.entities.Student;
import pao.project.entities.Teacher;
import pao.project.interfaces.IGradeService;
import pao.project.repositories.GradeRepository;
import pao.project.repositories.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService implements IGradeService {

    CsvLogger logger = CsvLogger.getInstance();

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<Grade> getGradesGivenThisMonth() {
        logger.logMessage("Got grades given this month");
        List<Grade> grades = gradeRepository.findAll();
        List<Grade> gradesThisMonth = new ArrayList<Grade>();

        for(Grade grade : grades) {
            LocalDate gradeDate = grade.getDate();
            LocalDate today = LocalDate.now();

            if (gradeDate.getMonth() == today.getMonth() && gradeDate.getYear() == today.getYear()) {
                gradesThisMonth.add(grade);
            }
        }

        return gradesThisMonth;
    }

    @Override
    public Grade getGrade(Long id) {
        logger.logMessage("Get grade " + id.toString());
        return gradeRepository.getById(id);
    }

    @Override
    public void deleteGrade(Long id) {
        logger.logMessage("Delete grade "+ id.toString());
        gradeRepository.deleteById(id);
    }

    @Override
    public void updateGrade(Grade grade) {
        logger.logMessage("Update grade " + grade.getId());
        gradeRepository.deleteById(grade.getId());
        gradeRepository.save(grade);
    }

    @Override
    public void saveGrade(Grade grade) {
        logger.logMessage("Saved new grade");
        gradeRepository.save(grade);
    }

    @Override
    public void saveGrades(List<Grade> grades) {
        logger.logMessage("Saved multiple new grades");
        for (Grade grade : grades) {
            gradeRepository.save(grade);
        }
    }
}
