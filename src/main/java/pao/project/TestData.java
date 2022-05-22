package pao.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pao.project.entities.Teacher;
import pao.project.entities.Course;
import pao.project.entities.Student;
import pao.project.entities.Grade;
import pao.project.services.CourseService;
import pao.project.services.GradeService;
import pao.project.services.StudentService;
import pao.project.services.TeacherService;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class TestData {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private GradeService gradeService;


    private static List<Student> studentList = Arrays.asList(
        new Student("Andrei", "Johnson", "andreij@gmail.com", LocalDate.of(2000, 10, 1)),
        new Student("Big", "Bob", "bbob@yahoo.com", LocalDate.of(2001, 9, 2)),
        new Student("Hailey", "Smith", "haith@example.com", LocalDate.of(2001,7,23)),
        new Student("John", "Wick", "guns@dog.com", LocalDate.of(1986, 2, 13)),
        new Student("Gigel", "Peste", "gigelpenet@yahoo.com", LocalDate.of(2001,1,15)),
        new Student("Robert", "Pisica", "rocat@yahoo.com", LocalDate.of(2000,4,24)),
        new Student("Willy", "Wonka", "chocolate@factory.com", LocalDate.of(2000, 5, 25)),
        new Student("Biggie", "Smalls", "smalls@big.com", LocalDate.of(2002, 10, 28))
    );

    private static List<Teacher> teacherList = Arrays.asList(
        new Teacher("Valentin", "Petrescu", "valistie@gmail.com", LocalDate.of(1990, 2, 25)),
        new Teacher("Data", "McMock", "placeholder@example.com", LocalDate.of(1987, 11, 29)),
        new Teacher("Faurt", "Knight", "free@bucks.com", LocalDate.of(1988, 12, 22)),
        new Teacher("Agent", "47", "io@interactive.com", LocalDate.of(1980, 10, 10)),
        new Teacher("Albert", "Einstein", "relative@bingmail.com", LocalDate.of(1922, 5, 24)),
        new Teacher("Amber", "Heard", "sheetsurprise@gmail.com", LocalDate.of(1988, 3, 26))
    );

    private static List<Course> courseList = Arrays.asList(
        new Course("Chemistry", 10, teacherList.get(0), new HashSet<>(studentList.subList(0, 3))),
        new Course("Algebra", 4, teacherList.get(1), new HashSet<>(studentList.subList(3, 6))),
        new Course("Physics", 10, teacherList.get(2), new HashSet<>(studentList.subList(0, 4))),
        new Course("Law", 11, teacherList.get(3), new HashSet<>(studentList.subList(4, 6))),
        new Course("English", 8, teacherList.get(4), new HashSet<>(studentList.subList(2,5))),
        new Course("Acting", 12, teacherList.get(5), new HashSet<>(studentList.subList(2,4)))
    );

    private static List<Grade> gradeList = Arrays.asList(
        new Grade(10, LocalDate.now(), studentList.get(0), courseList.get(0)),
        new Grade(10, LocalDate.now(), studentList.get(0), courseList.get(0)),
        new Grade(9, LocalDate.now(), studentList.get(0), courseList.get(0)),
        new Grade(9, LocalDate.now(), studentList.get(1), courseList.get(2)),
        new Grade(5, LocalDate.now(), studentList.get(1), courseList.get(2)),
        new Grade(6, LocalDate.now(), studentList.get(1), courseList.get(0)),
        new Grade(3, LocalDate.now(), studentList.get(2), courseList.get(4)),
        new Grade(5, LocalDate.now(), studentList.get(2), courseList.get(5)),
        new Grade(8, LocalDate.now(), studentList.get(3), courseList.get(1)),
        new Grade(10, LocalDate.now(), studentList.get(4), courseList.get(3)),
        new Grade(10, LocalDate.now(), studentList.get(4), courseList.get(4)),
        new Grade(6, LocalDate.now(), studentList.get(5), courseList.get(3)),
        new Grade(5, LocalDate.now(), studentList.get(5), courseList.get(3)),
        new Grade(3, LocalDate.now(), studentList.get(5), courseList.get(1)),
        new Grade(8, LocalDate.now(), studentList.get(6), courseList.get(1)),
        new Grade(7, LocalDate.now(), studentList.get(6), courseList.get(3)),
        new Grade(7, LocalDate.now(), studentList.get(6), courseList.get(1)),
        new Grade(7, LocalDate.now(), studentList.get(6), courseList.get(3))
    );

    public void saveAll() {
        studentService.saveStudents(studentList);
        teacherService.saveTeachers(teacherList);
        courseService.saveCourses(courseList);
        gradeService.saveGrades(gradeList);
    }
}


