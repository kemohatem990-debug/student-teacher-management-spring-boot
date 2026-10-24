package com.example.task.exception;

public class TeacherNotFoundException extends RuntimeException {

    public TeacherNotFoundException(Long id) {
        super("Teacher with id " + id + " not found");
    }
    
}
