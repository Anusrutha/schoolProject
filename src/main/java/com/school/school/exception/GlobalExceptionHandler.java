package com.school.school.exception;


import com.school.school.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<ResponseDto> globalExceptionHandler(Exception exception, WebRequest request) {

        System.out.println("i am in globalExceptionHandler");
        System.out.println("exception" + exception.getClass());

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(exception.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);

    }


    //This is for specific exception to handle

    @ExceptionHandler(StudentException.class)
    public ResponseEntity<ResponseDto> studentExceptionHandler(StudentException ex,WebRequest request) {
        System.out.println("i am in studentExceptionHandler");

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(ex.getMessage());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }

     @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> methodArgumentNotValidException(MethodArgumentNotValidException ex,WebRequest request) {
        System.out.println("i am in studentExceptionHandler");

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(ex.getMessage());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }




}