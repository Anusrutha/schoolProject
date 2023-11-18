package com.school.school.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
//@Builder
@Setter
public class ResponseDto {

    private String message;
    private String statusCode;
}
