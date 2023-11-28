package com.school.school.service;

import com.school.school.entity.Student;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentServiceInterface {
    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public String deleteStudentById(int id);

    public List<Student> readAllStudents();

    public Student readAllStudentsById(int id);

    public List<Student> getStudentByName(String studentName);

    int addValues(int a, int b);
    int addMoreValues(int a, int b);

}




