package com.school.school.service;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.UserRegistration;
import com.school.school.entity.Login;
import com.school.school.entity.Student;
import com.school.school.repository.LoginRepository;
import com.school.school.repository.StudentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    StudentRepo studentRepo;



    @Override
    public ResponseDto login(String userName, String password) {

//        Optional<List<Student>> response = studentRepo.findByStudentIdBetweenOrderByStudentIdDesc(5, 10);
//        Optional<List<Student>> response = studentRepo.myownQueryMethod();
        Optional<List<Student>> response = studentRepo.jpaQueryMethodWithParam("Vaish");
        response.ifPresent(student-> System.out.println(student));

        Optional<Login> loginOptional = loginRepository.findByUserNameAndPassword(userName, password);


        ResponseDto responseDto = new ResponseDto();

        if (loginOptional.isPresent()) {
            responseDto.setMessage("login successfully");
            responseDto.setStatusCode(HttpStatus.OK.name());
        } else {
            responseDto.setMessage("invalid credintials");
            responseDto.setStatusCode(HttpStatus.UNAUTHORIZED.name());
        }

        return responseDto;
    }

    @Override
    public ResponseDto userCreation( UserRegistration userRegistration) {

        Login login=new Login();
        BeanUtils.copyProperties(userRegistration, login);
        loginRepository.save(login);


        ResponseDto responseDto=new ResponseDto();
        responseDto.setStatusCode(HttpStatus.CREATED.name());
        responseDto.setMessage("user successfully registered");

        return responseDto;
    }
}
