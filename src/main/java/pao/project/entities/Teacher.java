package pao.project.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher extends Person {

    @OneToMany(mappedBy="teacher")
    private Set<Course> courses;


    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String email, LocalDate dateOfBirth) {
        super(firstName, lastName, email, dateOfBirth);
        courses = new HashSet<>();
    }

    public Teacher(String firstName, String lastName, String email, LocalDate dateOfBirth, Set<Course> courses) {
        super(firstName, lastName, email, dateOfBirth);
        this.courses = courses;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
