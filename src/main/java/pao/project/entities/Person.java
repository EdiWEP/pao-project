package pao.project.entities;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;


    public Person() {
        id = null;
        firstName = "default";
        lastName = "default";
        email = "0@default.com";
        dateOfBirth = null;
    }

    public Person(String firstName, String lastName, String email, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    // Returns firstName + lastName separated by a space
    public String fullName() {
        return firstName + ' ' + lastName;
    }
    // Returns lastName + firstName if reverse == true
    public String fullName(boolean reverse) {
        if (reverse) {
            return lastName + ' ' + firstName;
        }
        else return fullName();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
