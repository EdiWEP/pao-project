package pao.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pao.project.entities.Course;
import pao.project.entities.Student;
import pao.project.entities.Teacher;
import pao.project.services.CourseService;
import pao.project.services.GradeService;
import pao.project.services.StudentService;
import pao.project.services.TeacherService;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
public class PaoApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private GradeService gradeService;
	@Autowired
	private TestData testData;

	public static void main(String[] args) {
		SpringApplication.run(PaoApplication.class, args);
	}

	@Override
	public void run(String... args) {

		System.out.println("\n\n\n\n\n\n\nAPPLICATION STARTED\n");


//		testData.saveAll();

		System.out.println(teacherService.getNumberOfTaughtCourses(2L));
		System.out.println(courseService.getAverageGradeInCourse(1L));
		System.out.println(courseService.getTotalCredits());
		System.out.println(courseService.getCourseWithHighestCredits());
		System.out.println(courseService.getStudentsWithoutGrades(1L));
		System.out.println(courseService.getPercentageOfGradesAbove(1L, 9));
		System.out.println(studentService.getNumberOfGrades(1L));
		System.out.println(studentService.getStudentsWithGradesLowerThan(5));
		System.out.println(studentService.getAverageGradeById(1L));
		System.out.println(studentService.getAllAverageGrades());
		System.out.println(studentService.getAverageGradeByIdInCourse(1L, courseService.getCourse(1L)));
		System.out.println(studentService.getStudentsWithBirthdaysThisMonth());
		System.out.println(gradeService.getGradesGivenThisMonth());
	}

}
