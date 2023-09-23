package com.example.studentservice.controller;

import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController
{
    public final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void saveStudent(@RequestBody Student student)
    {
        studentService.saveStudent(student);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> findAllStudents()
    {
        return studentService.findAllStudents();
    }

    @GetMapping("/school/{school-id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> findAllStudents(@PathVariable("school-id") Long id)
    {
        return studentService.findAllStudentsBySchool(id);
    }
}
