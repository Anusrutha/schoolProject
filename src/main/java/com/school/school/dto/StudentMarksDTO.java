package com.school.school.dto;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class StudentMarksDTO {



    private int studentMarksId;
    private int studentMarks;
    private int studentId;
    private String subjectCode;

}
