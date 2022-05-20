package pao.project.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Teacher extends Person {

    @OneToMany(mappedBy="teacher")
    private Set<Course> courses;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String email, Date dateOfBirth) {
        super(firstName, lastName, email, dateOfBirth);

    }
}
