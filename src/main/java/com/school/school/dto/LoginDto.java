package com.school.school.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginDto {
   private String userName;
   private String password;
}
