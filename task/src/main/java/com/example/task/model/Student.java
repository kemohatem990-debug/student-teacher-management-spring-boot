package com.example.task.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
@Table(name="students")
@Entity
public class Student {
    @ManyToOne 
    @JoinColumn (name="teacher_id")

    private Teacher teacher;
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank 
    private String name;
    @Min(value = 1, message = "Age must be a positive number")
    private Integer age;
    @Email 
    private String email;

    public Student(String name, Integer age, String email, Long  id) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.id = id;
    }
    public Student() {
    }
    public String getName() {
        return name;
    }   
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
