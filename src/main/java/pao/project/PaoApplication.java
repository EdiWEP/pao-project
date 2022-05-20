package pao.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pao.project.entities.Student;
import pao.project.services.StudentService;

import java.util.Date;
import java.util.Scanner;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
public class PaoApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(PaoApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Scanner input = new Scanner(System.in);
		System.out.println("\n\n\n\n\n\n\nAPPLICATION STARTED\n");

		CsvLogger logger = CsvLogger.getInstance();

		logger.logMessage("Buna este ora 2");

//		Student s2 = new Student("h3i","hello","mee9", new Date());
//
//
//		studentService.saveStudent(s2);

	}

}
