package com.prince.student.service;

import com.prince.student.entity.Student;

import java.util.List;

public interface StudentService  {

    Student createOne(Student student);
    List<Student> getAll();
    Student getOne(Integer id);

}
