package com.school.school.controller;

import com.school.school.dto.LoginDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.UserRegistration;
import com.school.school.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/login")
@Validated
public class LoginController {

    @Autowired
    LoginService loginService;


    @PostMapping("")
    public ResponseDto userLogin(@RequestHeader Map<String, String> headers, @RequestBody LoginDto loginDto) {
        headers.forEach((key, value) -> {

            System.out.println("key: " + key + " value: " + value);

        });
        return loginService.login(loginDto.getUserName(), loginDto.getPassword());

    }


    @PostMapping("/user")
    public ResponseEntity<ResponseDto> userCreation(@Valid @RequestBody  UserRegistration userRegistration) {

        return new ResponseEntity<>(loginService.userCreation(userRegistration), HttpStatus.CREATED);

    }

}
