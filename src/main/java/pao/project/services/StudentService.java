package pao.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pao.project.CsvLogger;
import pao.project.entities.Course;
import pao.project.entities.Grade;
import pao.project.entities.Student;
import pao.project.entities.Teacher;
import pao.project.interfaces.IStudentService;
import pao.project.repositories.StudentRepository;

import java.util.*;

@Service
public class StudentService implements IStudentService {

    CsvLogger logger = CsvLogger.getInstance();

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Map<Student, Float> getAllAverageGrades() {

        List<Student> students = studentRepository.findAll();
        Map<Student, Float> gradesMap = new HashMap<Student, Float>();

        for(Student student : students) {
            gradesMap.put(student, getAverageGradeById(student.getId()));
        }

        logger.logMessage("Got all average grades");
        return gradesMap;
    }

    @Override
    public float getAverageGradeByIdInCourse(Long id, Course course) {
        logger.logMessage("Got average grade of student " + id.toString() + " in course " + course.getId());
        Student student = studentRepository.getById(id);

        Set<Grade> grades = student.getGrades();
        float sum = 0;
        int count = 0;

        for (Grade grade : grades) {
            if (grade.getCourse().getId() == course.getId()) {
                sum = sum + grade.getGrade();
                count = count + 1;
            }
        }

        return sum / count;
    }

    @Override
    public float getAverageGradeById(Long id) {
        logger.logMessage("Got grade average of student " + id.toString());
        Student student = studentRepository.getById(id);
        Set<Grade> grades = student.getGrades();
        float sum = 0;
        int numberOfGrades = grades.size();

        for(Grade grade : grades) {
            sum = sum + grade.getGrade();
        }

        return sum / numberOfGrades;
    }

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
