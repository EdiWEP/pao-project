package pao.project.entities;

import javax.persistence.*;
import java.util.Date;
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

    @OneToMany(mappedBy = "course")
    private Set<Grade> grades;

    @ManyToMany
    private Set<Student> students;

    public Course() {
    }

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
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
}
