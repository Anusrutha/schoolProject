package com.school.school.controller;

import com.school.school.entity.Teacher;
import com.school.school.service.TeacherInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("")
public class TeacherController {
    @Autowired
    TeacherInterface teacherInterface;

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher){

        return teacherInterface.addTeacher(teacher);
    }

    @PutMapping
    public Teacher updateTeacher(@RequestBody Teacher teacher){

        return  teacherInterface.updateTeacher(teacher);
    }

    @DeleteMapping("/teachers/{id}")
    public String deleteTeacherByID(@PathVariable("id") int id){
          teacherInterface.deleteTeacherByID(id);
        return "Deleted";
    }

    @GetMapping
    public  Teacher readTeacherByID(@PathVariable("id") int id){
        Teacher readTeacher = teacherInterface.readTeacherByID(id);
        return readTeacher;

    }

}
