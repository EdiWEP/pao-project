package pao.project.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int credits;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "course", cascade = {CascadeType.REMOVE})
    private Set<Grade> grades;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "student_course",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private Set<Student> students;

    public Course() {
    }

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
        this.students = new HashSet<>();
        this.grades = new HashSet<>();
    }

    public Course(String name, int credits, Teacher teacher) {
        this.name = name;
        this.credits = credits;
        this.teacher = teacher;
        this.students = new HashSet<>();
        this.grades = new HashSet<>();
    }

    public Course(String name, int credits, Teacher teacher, Set<Student> students) {
        this.name = name;
        this.credits = credits;
        this.teacher = teacher;
        this.students = students;
        this.grades = new HashSet<>();
    }

    public Course(String name, int credits, Teacher teacher, Set<Grade> grades, Set<Student> students) {
        this.name = name;
        this.credits = credits;
        this.teacher = teacher;
        this.grades = grades;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
