package com.school.school.controller;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.StudentMarksDTO;
import com.school.school.entity.Student;
import com.school.school.entity.StudentMarks;
import com.school.school.entity.Subjects;
import com.school.school.service.StudentMarksInterface;
import com.school.school.service.StudentMarksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/school")



public class StudentMarksController {

    @Autowired
    StudentMarksInterface studentMarksInterface;


    @PostMapping("/student/studentMarks")
    public ResponseEntity<ResponseDto> addMarks(@RequestBody StudentMarksDTO studentMarksDTO){




   StudentMarks      newMarks = studentMarksInterface.addMarks(studentMarksDTO);
        return  null;
    }

    @GetMapping("/student/studentMarks")
    public ResponseEntity<Optional <List<StudentMarksDTO>>> getMarks(){
        return new ResponseEntity<>(studentMarksInterface.getMarks(),HttpStatus.OK);

        //Optional<List<StudentMarks>> allStudentMarks=studentMarksInterface.getMarks(studentMarksDTO);

    }

    @GetMapping("/student/studentMarks/{id}")
    public ResponseEntity<Optional<StudentMarks>> getMarksById(@PathVariable("id") int id){

        return  new ResponseEntity<>(studentMarksInterface.getMarksById(id),HttpStatus.OK);
    }


}
