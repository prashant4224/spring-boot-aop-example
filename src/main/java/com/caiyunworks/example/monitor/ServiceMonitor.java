package com.caiyunworks.example.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by tonywang on 1/11/16.
 */
@Aspect
@Component
public class ServiceMonitor {
    @Before("execution(* com..*Service*.*(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        System.out.println("Completed: " + joinPoint);
    }

    @Before("execution(* org.jooq.impl.DAOImpl+.*(..))")
    public void logDaoAccess(JoinPoint joinPoint) {
        System.out.println("Completed: " + joinPoint);
    }
}
