package com.school.school.controller;

import com.school.school.dto.ResponseDto;
import com.school.school.entity.Student;
import com.school.school.service.Student2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students2")
public class Student2Controller {

    @Autowired
    Student2Service student2Service;


    @PostMapping("")
    public ResponseEntity<Optional<ResponseDto>> addStudent(@RequestBody Student student) {

        return new ResponseEntity<>(student2Service.addStudent(student), HttpStatus.CREATED);

    }

    @PutMapping("")
    ResponseEntity<Optional<Student>> updateStudent(@RequestBody Student student) {
        return new ResponseEntity<>(student2Service.updateStudent(new Student()), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    ResponseEntity<Optional<String>> deleteStudentById(@PathVariable("id") int id) {
        return new ResponseEntity<>(student2Service.deleteStudentById(id), HttpStatus.OK);

    }

    @GetMapping("")
    ResponseEntity<Optional<List<Student>>> readAllStudents() {
        return new ResponseEntity<>(student2Service.readAllStudents(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<Student>> readAllStudentsById(@PathVariable("id") int id) {
        return new ResponseEntity<>(student2Service.readAllStudentsById(id), HttpStatus.OK);

    }
}
