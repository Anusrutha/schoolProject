package com.school.school.service;


import com.school.school.dto.ResponseDto;
import com.school.school.dto.StudentDto;
import com.school.school.entity.Student;
import com.school.school.repository.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;
import java.util.Optional;

@SpringBootTest
public class Student2ServiceImplTest {

    @Mock
    StudentRepo studentRepo;
    @InjectMocks
    Student2ServiceImpl student2ServiceImpl;



    Student student=new Student();

    @BeforeEach
    public void setup(){
        student.setStudentId(1);
        student.setStudentContact("1234567890");
        student.setStudentEmail("alex123@gmail.com");
        student.setStudentName("Alex");
        student.setGender("MALE");
    }


    @Test
    public void addStudentTest(){
        //when then return

        Mockito.when(studentRepo.save(Mockito.any(Student.class))).thenReturn(student);
        Optional<ResponseDto> response = student2ServiceImpl.addStudent(student);

        System.out.println("response Dto"+ response.get());

        Assert.notNull(response);

        Assertions.assertEquals(response.get().getMessage(),"student successfully created");
        Assertions.assertEquals(response.get().getStatusCode(),"SUCCESS");



    }


    @Test
    public void addStudentTestFailed(){
        student.setGender("kkkk");

        //when then return

        Mockito.when(studentRepo.save(Mockito.any(Student.class))).thenReturn(student);
        Optional<ResponseDto> response = student2ServiceImpl.addStudent(student);

        System.out.println("response Dto"+ response.get());

        Assert.notNull(response);
        Assertions.assertEquals(response.get().getMessage(),"failed to create student");
        Assertions.assertEquals(response.get().getStatusCode(),"FAILED");



    }





}
