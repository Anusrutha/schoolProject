package com.school.school.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudentDto {

    private int studentId;
    private String studentName;
    private String studentContact;
    private String studentEmail;


}