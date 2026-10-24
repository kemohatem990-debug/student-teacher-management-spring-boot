package com.example.task.dto;

public class StudentResponse {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private TeacherSummary teacher;

    public StudentResponse() {
    }

    public StudentResponse(Long id, String name, Integer age, String email, TeacherSummary teacher) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.teacher = teacher;
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

    public TeacherSummary getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherSummary teacher) {
        this.teacher = teacher;
    }
}
