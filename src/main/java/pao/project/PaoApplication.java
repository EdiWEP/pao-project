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

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
public class PaoApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private GradeService gradeService;

	public static void main(String[] args) {
		SpringApplication.run(PaoApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Scanner input = new Scanner(System.in);
		System.out.println("\n\n\n\n\n\n\nAPPLICATION STARTED\n");

		CsvLogger logger = CsvLogger.getInstance();

		logger.logMessage("Buna este ora 2");

//		Teacher t2 = new Teacher("Super", "Batman", "jleaguecontact@gmail.com", LocalDate.of(66,1,1));
//
//
//		Course c1 = new Course("Testing", 10, t2);
//
//		courseService.saveCourse(c1);
//		teacherService.saveTeacher(t2);
//		Teacher t1 = new Teacher("Valentin", "Popescu", "vpop@gmail.com", LocalDate.of(1990,12,12));
//
//		teacherService.saveTeacher(t1);
//		Student s2 = new Student("h3i","hello","mee9", new Date());
//
//
//		studentService.saveStudent(s2);

	}

}
