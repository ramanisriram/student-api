package com.playtech.springbootrestapi.controller;

import com.playtech.springbootrestapi.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("students-api")
public class StudentController {
    private List<Student> studentslist = new ArrayList<Student>();


    @CrossOrigin
    @GetMapping("studentslist")
    public List<Student> getAllStudents() {

        if(studentslist.isEmpty()) {
            Student student1 = new Student(1, "Sriram", "Ramani");
            Student student2 = new Student(2, "Sivaprakash", "C");
            Student student3 = new Student(3, "Praveen", "Kumar");
            studentslist.add(student1);
            studentslist.add(student3);
            studentslist.add(student2);
        }

        return studentslist;
    }

    //{id} URI template variable
    @CrossOrigin
    @GetMapping("students/{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int id) {
        List<Student> foundStudent = studentslist.stream().filter(a->a.getId()==id).collect(Collectors.toList());
        return ResponseEntity.ok(foundStudent.get(0));
    }

    //Spring boot REST API with request param - must be in the request body

    //Spring Boot REST API that handles HTTP Post Request
    @PostMapping("students/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println("First name:" + student.getId());
        System.out.println("First name:" + student.getFirstName());
        System.out.println("Last name:" + student.getLastName());
        studentslist.add(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

}
