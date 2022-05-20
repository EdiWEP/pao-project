package pao.project.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student extends Person {

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

    @OneToMany(mappedBy = "student")
    private Set<Grade> grades;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, LocalDate dateOfBirth) {
        super(firstName, lastName, email, dateOfBirth);
        courses = new HashSet<>();
        grades = new HashSet<>();
    }

    public Student(String firstName, String lastName, String email, LocalDate dateOfBirth, Set<Course> courses, Set<Grade> grades) {
        super(firstName, lastName, email, dateOfBirth);
        this.courses = courses;
        this.grades = grades;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }
}
