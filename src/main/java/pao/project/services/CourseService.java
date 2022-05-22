package pao.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pao.project.CsvLogger;
import pao.project.entities.Course;
import pao.project.entities.Grade;
import pao.project.entities.Student;
import pao.project.entities.Teacher;
import pao.project.interfaces.ICourseService;
import pao.project.repositories.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CourseService implements ICourseService {

    CsvLogger logger = CsvLogger.getInstance();

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public float getPercentageOfGradesAbove(Long id, int grade) {
        logger.logMessage("Got percentage of grade above " + grade + " for course " + id.toString());
        Course course = courseRepository.getById(id);
        Set<Grade> courseGrades = course.getGrades();

        float percentage = 0;
        float numberOfGrades = courseGrades.size();
        float gradesAbove = 0;

        for(Grade gradeObject : courseGrades) {
            if (gradeObject.getGrade() >= grade) {
                gradesAbove = gradesAbove + 1;
            }
        }
        percentage = gradesAbove/numberOfGrades * 100;
        return percentage;
    }

    @Override
    public List<Student> getStudentsWithoutGrades(Long id) {
        logger.logMessage("Got students with grades in course " + id.toString());
        Course course = courseRepository.getById(id);
        Set<Student> students = course.getStudents();
        List<Student> studentsWithoutGrades = new ArrayList<Student>();

        for (Student student : students) {
            Set<Grade> studentGrades = student.getGrades();
            boolean add = true;

            for(Grade grade : studentGrades) {
                if (grade.getCourse().getId() == course.getId()) {
                    add = false;
                    break;
                }
            }

            if (add) {
                studentsWithoutGrades.add(student);
            }
        }

        return studentsWithoutGrades;
    }

    @Override
    public Course getCourseWithHighestCredits() {
        logger.logMessage("Got course with highest credits");
        List<Course> courses = courseRepository.findAll();

        int max = 0;
        Course maxCourse = null;

        for (Course course : courses) {
            int courseCredits = course.getCredits();

            if (courseCredits > max) {
                max = courseCredits;
                maxCourse = course;
            }
        }

        return maxCourse;
    }

    @Override
    public int getTotalCredits() {
        logger.logMessage("Got total credits");
        List<Course> courses = courseRepository.findAll();

        int sum = 0;

        for(Course course : courses) {
            sum = sum + course.getCredits();
        }

        return sum;
    }

    @Override
    public float getAverageGradeInCourse(Long id) {
        logger.logMessage("Got average grade of course " + id.toString());
        Set<Grade> grades = courseRepository.getById(id).getGrades();
        float sum = 0;
        int numberOfGrades = grades.size();

        for(Grade grade : grades) {
            sum = sum + grade.getGrade();
        }

        return sum / numberOfGrades;
    }

    @Override
    public Course getCourse(Long id) {
        logger.logMessage("Get course " + id.toString());
        return courseRepository.getById(id);
    }

    @Override
    public void deleteCourse(Long id) {
        logger.logMessage("Delete course "+ id.toString());
        courseRepository.deleteById(id);
    }

    @Override
    public void updateCourse(Course course) {
        logger.logMessage("Update course " + course.getId());
        courseRepository.deleteById(course.getId());
        courseRepository.save(course);
    }

    @Override
    public void saveCourse(Course course) {
        logger.logMessage("Saved new course");
        courseRepository.save(course);
    }

    @Override
    public void saveCourses(List<Course> courses) {
        logger.logMessage("Saved multiple new courses");
        for (Course course : courses) {
            courseRepository.save(course);
        }
    }
}
