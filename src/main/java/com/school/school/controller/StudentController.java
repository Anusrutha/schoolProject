package com.school.school.controller;

import com.school.school.dto.ResponseDto;
import com.school.school.entity.Student;
import com.school.school.service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentServiceInterface serviceInterface;

    @PostMapping("/students")
    public Student student(@RequestBody Student student) {
        Student newStudent = serviceInterface.addStudent(student);


        return newStudent;

    }


    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        Student updatedStudent = serviceInterface.updateStudent(student);
        return updatedStudent;
    }


    @DeleteMapping("/students/{id}")
    public ResponseDto delStudentByID(@PathVariable("id") int id) {

        String deleteStudent = serviceInterface.deleteStudentById(id);

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(deleteStudent);


        return responseDto;
    }

    @GetMapping("/students")
    public List<Student> readAllStudents() {
        List<Student> allStudents = serviceInterface.readAllStudents();
        return allStudents;
    }

    @GetMapping("/students/{id}")
    public Student readById(@PathVariable int id) {
        Student readStudent = serviceInterface.readAllStudentsById(id);
        return readStudent;
    }

    @GetMapping("/students-filter")
    public List<Student> getStudentByName(@RequestParam("studentName") String studentName) {
        return serviceInterface.getStudentByName(studentName);
    }


}
