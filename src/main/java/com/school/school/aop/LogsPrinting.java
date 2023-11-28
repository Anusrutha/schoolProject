package com.school.school.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogsPrinting {

    @Before("execution(* com.school.school.controller.LoginController.userLogin(..))")
    public void beforeMethodLog(){
        System.out.println("in aop start time: "+ System.currentTimeMillis() );
    }
    @After("execution(* com.school.school.controller.LoginController.userLogin(..))")
    public void afterMethodLog(){
            System.out.println("in aop end time: "+ System.currentTimeMillis() );
        }
}
