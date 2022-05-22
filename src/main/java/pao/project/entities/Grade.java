package pao.project.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int grade;
    private LocalDate date;

    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;

    public Grade() {
    }

    public Grade(int grade, LocalDate date) {
        this.grade = grade;
        this.date = date;
    }

    public Grade(int grade, LocalDate date, Student student, Course course) {
        this.grade = grade;
        this.date = date;
        this.student = student;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grade=" + grade +
                ", date=" + date +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
