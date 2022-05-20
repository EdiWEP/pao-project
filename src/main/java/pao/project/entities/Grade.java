package pao.project.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int grade;
    private Date date;

    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;

    public Grade() {
    }

    public Grade(int grade, Date date) {
        this.grade = grade;
        this.date = date;
    }

    public Grade(int grade, Date date, Student student, Course course) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
