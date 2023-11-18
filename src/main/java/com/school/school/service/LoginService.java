package com.school.school.service;

import com.school.school.dto.LoginDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.UserRegistration;
import com.school.school.entity.Login;
import org.springframework.web.bind.annotation.RequestBody;

public interface LoginService {

    ResponseDto login(String userName, String password);
     ResponseDto userCreation( UserRegistration userRegistration);
}
