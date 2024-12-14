package entity;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class TeacherEntiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String subject;

    public TeacherEntiry() {
    }

    public TeacherEntiry(int id, String name, String city, String subject) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
