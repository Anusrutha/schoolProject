package com.school.school.service;

import com.school.school.entity.Student;
import com.school.school.repository.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Optional;

@SpringBootTest
public class StudentServiceTest {
    @Mock
    StudentRepo studentRepo;

    @InjectMocks
    StudentService studentService;


    @Test
    public void updateStudent(){
        Student student=new Student();
        student.setStudentId(1);
        student.setStudentName("Ben");
        student.setStudentEmail("ben321@gmail.com");
        student.setStudentContact("9807654321");
        student.setGender("MALE");

        Mockito.when(studentRepo.findById(1)).thenReturn(Optional.of(student));
        Mockito.when(studentRepo.save(Mockito.any(Student.class))).thenReturn(student);
       Student studentResponse=studentService.updateStudent(student);
       System.out.println("Student Response");
        Assert.notNull(studentResponse);

    }


    @Test
    public void addValuesTest(){
        int sum = studentService.addValues(2, 4);

        Assertions.assertEquals(sum,6);
    }

    @Test
    public void addMoreValuesTest(){
        int sum = studentService.addMoreValues(2, 4);

        Assertions.assertEquals(sum,7);
    }
}
