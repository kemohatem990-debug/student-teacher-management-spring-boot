package com.example.task.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentRequest {
    @NotBlank
    private String name;
    @NotNull
    @Min (value = 1, message = "Age must be a positive number")
    private Integer age;
    @Email
    private String email;
    public StudentRequest() {
    }
    public StudentRequest(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
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

}
