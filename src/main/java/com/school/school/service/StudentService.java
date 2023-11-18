package com.school.school.service;

import com.school.school.dto.EmailSendDto;
import com.school.school.entity.Student;
import com.school.school.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentServiceInterface {
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    RestTemplate restTemplate;
//Class cs= new Class();


    @Override
    public Student addStudent(Student student) {

        //student created in database
        Student studentResponse = studentRepo.save(student);

        //i need send the email to student

//         EmailSendDto emailSendDto=new EmailSendDto();
//         emailSendDto.setEmailId(studentResponse.getStudentEmail());
//         emailSendDto.setMessage(studentResponse.getStudentName()+" is successfully created with id "+studentResponse.getStudentId());

        EmailSendDto emailSendDto = EmailSendDto.builder()
                .message(studentResponse.getStudentName() + " is successfully created with id " + studentResponse.getStudentId())
                .emailId(studentResponse.getStudentEmail())
                .build();


//        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> emailResponse = restTemplate.postForEntity("http://localhost:8081/email", emailSendDto, String.class);

//        System.out.println("emailResponse:");
//        System.out.println(emailResponse.getBody());

        return studentResponse;
    }

    @Override
    public Student updateStudent(Student student) {
        //Need to get the student details from database using id
        Optional<Student> studentOptional = studentRepo.findById(student.getStudentId());

        boolean status = studentOptional.isPresent();
        if (!status) {
            throw new NullPointerException("Invalid StudentID");
        }

       /* studentOptional.ifPresent( student1 -> {
            System.out.println(student1);
        });*/

        Student student1 = studentOptional.get();
        student1.setStudentContact(student.getStudentContact());
        student1.setStudentEmail(student.getStudentEmail());
        student1.setStudentName(student.getStudentName());


        Student studentResponse = studentRepo.save(student1);
        return studentResponse;

    }

    @Override
    public String deleteStudentById(int id) {
        studentRepo.deleteById(id);
        return "successfully deleted";


    }

    @Override
    public List<Student> readAllStudents() {
        List<Student> allStudents = studentRepo.findAll();
        return allStudents;
    }

    @Override
    public Student readAllStudentsById(int id) {
        Optional<Student> readStudent = studentRepo.findById(id);
        if (readStudent.isPresent()) {
            return readStudent.get();
        } else {
            throw new ArithmeticException("wrong id passed");
        }


    }

    @Override
    public List<Student> getStudentByName(String studentName) {
        return studentRepo.findByStudentName(studentName);
    }
}