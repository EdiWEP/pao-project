package pao.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pao.project.entities.Grade;
import pao.project.interfaces.IGradeService;
import pao.project.repositories.GradeRepository;

@Service
public class GradeService implements IGradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public void saveGrade(Grade grade) { gradeRepository.save(grade); }
}
