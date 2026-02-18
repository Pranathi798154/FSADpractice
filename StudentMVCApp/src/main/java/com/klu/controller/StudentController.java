package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Student;
import com.klu.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

     
    @GetMapping("/greet")
    public String welcome() {
        return service.getWelcomeMessage();
    }

    // Create 
    @PostMapping("/student/add")
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    // Get  By Id
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // Get All 
    @GetMapping("/student/getall")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // Update 
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // Delete 
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}