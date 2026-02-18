package com.klu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.model.Student;
import com.klu.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {   // <-- Fixed capital I

    private List<Student> studentList = new ArrayList<>();

    // welcome
    @Override
    public String getWelcomeMessage() {
        return "Welcome to Student MVC";
    }

    // create
    @Override
    public Student createStudent(Student student) {
        studentList.add(student);
        return student;
    }

    // read - get by ID
    @Override
    public Student getStudentById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new RuntimeException("Student not found with id: " + id);
    }

    // read - get all
    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    // update
    @Override
    public Student updateStudent(int id, Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                student.setId(id);
                studentList.set(i, student);
                return student;
            }
        }
        throw new RuntimeException("Student not found with id: " + id);
    }

    // delete
    @Override
    public String deleteStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                return "Student record deleted successfully";
            }
        }
        throw new RuntimeException("Student not found with id: " + id);
    }

    // search
    @Override
    public List<Student> searchStudent(String name) {
        List<Student> result = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getName().equalsIgnoreCase(name)) {
                result.add(s);
            }
        }
        return result;
    }
}