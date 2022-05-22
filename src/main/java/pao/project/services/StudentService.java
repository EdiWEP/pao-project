package pao.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pao.project.CsvLogger;
import pao.project.entities.Grade;
import pao.project.entities.Student;
import pao.project.entities.Teacher;
import pao.project.interfaces.IStudentService;
import pao.project.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class StudentService implements IStudentService {

    CsvLogger logger = CsvLogger.getInstance();

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudentsWithGradesLowerThan(int grade) {
        logger.logMessage("Got students with grades lower than " + grade);
        List<Student> returnList = new ArrayList<Student>();
        List<Student> students = studentRepository.findAll();

        for (Student student : students) {
            Set<Grade> grades = student.getGrades();

            for (Grade gradeObject : grades) {
                if (gradeObject.getGrade() < grade) {
                    returnList.add(student);
                    break;
                }
             }
        }
        return returnList;
    }

    @Override
    public int getNumberOfGrades(Long id) {
        logger.logMessage("Got number of grades of student " + id.toString());
        Student student = studentRepository.getById(id);
        return student.getGrades().size();
    }

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

    @Override
    public void saveStudents(List<Student> students) {
        logger.logMessage("Saved multiple new students");
        for (Student student : students) {
            studentRepository.save(student);
        }
    }
}
