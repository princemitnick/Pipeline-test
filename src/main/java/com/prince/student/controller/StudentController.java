package com.prince.student.controller;


import com.prince.student.entity.Student;
import com.prince.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getOne(@PathVariable("id") Integer id){
        return studentService.getOne(id);
    }

    @PostMapping
    public Student createOne(@RequestBody Student student){
        return studentService.createOne(student);
    }
}
