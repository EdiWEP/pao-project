package pao.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
public class PaoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PaoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner input = new Scanner(System.in);
		System.out.println("\n\n\n\n\n\n\nAPPLICATION STARTED\n");

		CsvLogger logger = CsvLogger.getInstance();

		logger.logMessage("Buna este ora 2");


	}

}
