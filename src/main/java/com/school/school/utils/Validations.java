package com.school.school.utils;

import com.school.school.exception.StudentException;

public class Validations {


    public static boolean marksValidation(int marks){
        if(marks>100 || marks<0){
            return false;
        }
        return true;
    }

}
