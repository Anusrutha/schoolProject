package com.school.school.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
//@Builder
@Setter
@ToString
public class ResponseDto {

    private String message;
    private String statusCode;
}
