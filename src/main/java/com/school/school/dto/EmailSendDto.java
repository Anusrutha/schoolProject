package com.school.school.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EmailSendDto {

    private String emailId;
    private String message;

}
