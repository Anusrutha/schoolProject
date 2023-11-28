package com.school.school.service;

import com.school.school.controller.StudentController;
import com.school.school.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest

public class StudentControllerTest {
    @Mock StudentService studentService;
    @InjectMocks
    StudentController studentController;

    @Test
    public void updateStudent(){
        Student student=new Student();
        student.setStudentId(1);
        student.setStudentName("Ben");
        student.setStudentEmail("ben321@gmail.com");
        student.setStudentContact("9807654321");
        student.setGender("MALE");
        Mockito.when(studentService.updateStudent(student)).thenReturn(student);
        Student responseStudent=studentController.updateStudent(student);
        Assert.notNull(responseStudent);
        Assertions.assertEquals(student.getStudentName(),responseStudent.getStudentName());

    }
}
