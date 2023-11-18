package com.school.school.service;

import com.school.school.dto.ResponseDto;
import com.school.school.entity.Student;

import java.util.List;
import java.util.Optional;

public interface Student2Service {

    Optional<ResponseDto> addStudent(Student student);

    Optional<Student> updateStudent(Student student);

    Optional<String> deleteStudentById(int id);

    Optional<List<Student>> readAllStudents();

    Optional<Student> readAllStudentsById(int id);

}
