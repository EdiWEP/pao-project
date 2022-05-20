package pao.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pao.project.CsvLogger;
import pao.project.entities.Student;
import pao.project.entities.Teacher;
import pao.project.interfaces.ITeacherService;
import pao.project.repositories.TeacherRepository;

@Service
public class TeacherService implements ITeacherService {

    CsvLogger logger = CsvLogger.getInstance();

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher getTeacher(Long id) {
        logger.logMessage("Get teacher " + id.toString());
        return teacherRepository.getById(id);
    }

    @Override
    public void deleteTeacher(Long id) {
        logger.logMessage("Delete teacher "+ id.toString());
        teacherRepository.deleteById(id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        logger.logMessage("Update teacher " + teacher.getId());
        teacherRepository.deleteById(teacher.getId());
        teacherRepository.save(teacher);
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        logger.logMessage("Saved new teacher");
        teacherRepository.save(teacher);
    }
}
