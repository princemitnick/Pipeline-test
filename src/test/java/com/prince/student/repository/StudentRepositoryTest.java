package com.prince.student.repository;


import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {
/**
    @Autowired
    private StudentRepository studentRepository;


    @Test
    void addStudent(){

        Student student = studentRepository.saveAndFlush(
                Student
                        .builder()
                        .dob(LocalDate.of(1992, 04, 01))
                        .gender(Gender.MALE)
                        .lastName("Jean Baptiste")
                        .firstName("Prince")
                        .build()
        );

        System.out.println("Student : "+student.getId()+" is created");

    }

    @Test
    void getAllStudent(){
        List<Student> students = studentRepository.findAll();
        students.forEach(student -> {
            System.out.println(student.toString());
        });
    }
    */
}