package com.school.school.service;

import com.school.school.dto.ResponseDto;
import com.school.school.entity.Gender;
import com.school.school.entity.Student;
import com.school.school.exception.StudentException;
import com.school.school.repository.StudentRepo;
import static com.school.school.utils.Constants.*;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class Student2ServiceImpl implements Student2Service {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public Optional<ResponseDto> addStudent(Student student) {


        try {
            if (Optional.of(Gender.valueOf(student.getGender())).isPresent()) {

                Optional<Student> studentOptional = Optional.of(studentRepo.save(student));

                ResponseDto responseDto = new ResponseDto();
                responseDto.setMessage(STUDENT_SUCCESS_CREATE_MESSAGE);
                responseDto.setStatusCode(SUCCESS_CODE);
                return Optional.of(responseDto);
            }
        }catch (Exception e){

         System.out.println("error in sudent message: "+e.getMessage());
      }

        ResponseDto responseDto=new ResponseDto();
        responseDto.setMessage(STUDENT_FAILED_MESSAGE);
        responseDto.setStatusCode(FAILED_CODE);
        return Optional.of(responseDto);


      /*  if (studentOptional.isPresent()) {
            return Optional.of(
                    ResponseDto.builder()
                            .message(STUDENT_SUCCESS_CREATE_MESSAGE)
                            .statusCode(SUCCESS_CODE)
                            .build()
            );
        } else {
            return Optional.of(
                    ResponseDto
                            .builder()
                            .message(STUDENT_SUCCESS_FAILED_MESSAGE)
                            .statusCode(FAILED_CODE)
                            .build());

        }*/





    }

    @Override
    public Optional<Student> updateStudent(Student student) {
        Optional<Student> studentOptional = studentRepo.findById(student.getStudentId());

        if (!studentOptional.isPresent()) {
            throw new NullPointerException("no student present with id : " + student.getStudentContact());
        }

        BeanUtils.copyProperties(student, studentOptional.get());
        return Optional.of(studentRepo.save(studentOptional.get()));


    }

    @Override
    public Optional<String> deleteStudentById(int id) {
        Optional<Student> studentOptional = studentRepo.findById(id);

        if (studentOptional.isPresent()) {

            studentRepo.deleteById(id);
            return Optional.of("successfully deleted");

        }else{
            throw new NullPointerException("no student present with id : " + id);

        }


    }

    @Override
    public Optional<List<Student>> readAllStudents() {

        return Optional.of(studentRepo.findAll());
    }

    @Override
    public Optional<Student> readAllStudentsById(int id) {
       /* Student studentOptional=new Student();
        try {
             studentOptional = studentRepo.findById(id).get();

        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("No id found" +noSuchElementException.getMessage());
        }
        return Optional.of( studentOptional);*/

        Optional<Student> studentOptional = studentRepo.findById(id);
        if (!studentOptional.isPresent()) {
            throw new StudentException("invalid student id: " + id);
//            throw new ArithmeticException("invalid student id: " + id);
        }
        return studentOptional;
    }
}
