package pao.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Student extends Person {


    public Student() {
    }

    public Student(String firstName, String lastName, String email, Date dateOfBirth) {
        super(firstName, lastName, email, dateOfBirth);

    }


}