package com.school.school.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Builder
@Getter
//@Validated
public class UserRegistration {
    @NotEmpty(message = "userName cannot be empty")
//    @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$",
//            message = "username must be of 6 to 12 length with no special characters")
    private String userName;

    @NotEmpty(message = "password cannot be empty")
    private String password;
    @NotEmpty(message = "email cannot be empty")
    @Email(message = "email is invalid")
    private String email;
}
