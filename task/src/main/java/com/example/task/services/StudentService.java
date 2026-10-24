package com.example.task.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.task.dto.StudentRequest;
import com.example.task.dto.StudentResponse;
import com.example.task.dto.TeacherSummary;
import com.example.task.exception.StudentNotFoundException;
import com.example.task.exception.TeacherNotFoundException;
import com.example.task.model.Student;
import com.example.task.model.Teacher;
import com.example.task.repository.StudentRepository;
import com.example.task.repository.TeacherRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;// attribute to hold the student repository
    private final TeacherRepository teacherRepository;// attribute to hold the teacher repository

    // constructor to initialize the student and teacher repositories
    public StudentService(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    // converts a Student entity into a StudentResponse DTO
    private StudentResponse toStudentResponse(Student student) {
        TeacherSummary teacherSummary = null;

        if (student.getTeacher() != null) {
            teacherSummary = new TeacherSummary(
                    student.getTeacher().getId(),
                    student.getTeacher().getName());
        }

        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail(),
                teacherSummary);
    }

    // method to assign a teacher to a student
    public StudentResponse assignTeacher(Long studentId, Long teacherId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new TeacherNotFoundException(teacherId));

        student.setTeacher(teacher);
        return toStudentResponse(studentRepository.save(student));
    }

    // get all students GET method (the logic to get all students from the database)
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::toStudentResponse)
                .toList();
    }

    // get student by id GET method (the logic to get a student by id from the database)
    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        return toStudentResponse(student);
    }

    // add student POST method (the logic to add a new student to the database)
    public StudentResponse AddStudent(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setEmail(request.getEmail());

        return toStudentResponse(studentRepository.save(student));
    }

    // update student PUT method with exception handling (the logic to update an existing student in the database)
    public StudentResponse updateStudent(Long id, StudentRequest request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setEmail(request.getEmail());

        return toStudentResponse(studentRepository.save(student));
    }

    // delete student DELETE method with exception handling (the logic to delete a student from the database)
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
    }
}