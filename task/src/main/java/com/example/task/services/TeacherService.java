package com.example.task.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.task.dto.TeacherRequest;
import com.example.task.dto.TeacherResponse;
import com.example.task.exception.TeacherNotFoundException;
import com.example.task.model.Teacher;
import com.example.task.repository.TeacherRepository;
@Service 
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    private TeacherResponse toTeacherResponse(Teacher teacher) {
    return new TeacherResponse(
            teacher.getId(),
            teacher.getAge(),
            teacher.getName(),
            teacher.getEmail(),
            teacher.getSubject());
}

    //get all teachers Get method
    // get all teachers GET method
public List<TeacherResponse> getAllTeachers() {
    return teacherRepository.findAll()
            .stream()
            .map(this::toTeacherResponse)
            .toList();
}
    // get teacher by id GET method
    public TeacherResponse getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
                return toTeacherResponse(teacher);
    }
    // add teacher POST method
public TeacherResponse addTeacher(TeacherRequest request) {
    Teacher teacher = new Teacher();
    teacher.setAge(request.getAge());
    teacher.setName(request.getName());
    teacher.setEmail(request.getEmail());
    teacher.setSubject(request.getSubject());

    return toTeacherResponse(teacherRepository.save(teacher));
}
   // update teacher PUT method
public TeacherResponse updateTeacher(Long id, TeacherRequest request) {
    Teacher teacher = teacherRepository.findById(id)
            .orElseThrow(() -> new TeacherNotFoundException(id));

    teacher.setName(request.getName());
    teacher.setAge(request.getAge());
    teacher.setEmail(request.getEmail());
    teacher.setSubject(request.getSubject());

    return toTeacherResponse(teacherRepository.save(teacher));
}

    // delete teacher DELETE method
    public void deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new TeacherNotFoundException(id);
        }
        teacherRepository.deleteById(id);
    }
}

