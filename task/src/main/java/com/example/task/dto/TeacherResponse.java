package com.example.task.dto;

public class TeacherResponse {
    
private Long id;
    private Integer age;
    private String name;
    private String email;
    private String subject;

    public TeacherResponse() {
    }

    public TeacherResponse(Long id, Integer age, String name, String email, String subject) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
