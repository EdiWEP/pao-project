package pao.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pao.project.CsvLogger;
import pao.project.entities.Student;
import pao.project.entities.Teacher;
import pao.project.interfaces.IStudentService;
import pao.project.repositories.StudentRepository;

@Service
public class StudentService implements IStudentService {

    CsvLogger logger = CsvLogger.getInstance();

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        logger.logMessage("Get student " + id.toString());
        return studentRepository.getById(id);
    }

    @Override
    public void deleteStudent(Long id) {
        logger.logMessage("Delete student "+ id.toString());
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        logger.logMessage("Update student " + student.getId());
        studentRepository.deleteById(student.getId());
        studentRepository.save(student);
    }

    @Override
    public void saveStudent(Student student) {
        logger.logMessage("Saved new student");
        studentRepository.save(student);
    }

}
