package com.example.task.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
public class TeacherRequest {
    @Min (value = 1, message = "Age must be a positive number")
    private Integer age;
    @NotBlank 
    private String name;
    @Email
    private String email;
    @NotBlank 
    private String subject;

    public TeacherRequest( Integer age, String name, String email, String subject) {
        
        this.age = age;
        this.name = name;
        this.email = email;
        this.subject = subject;
    }
    public TeacherRequest() {
    }
   
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}