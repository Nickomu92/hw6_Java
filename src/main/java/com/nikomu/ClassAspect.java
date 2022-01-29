package com.nikomu;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ClassAspect {

    @Around("execution(* com.nikomu.Candy.create*(..))")
    public void aroundCreateCandyAdvice(ProceedingJoinPoint joinPoint) {
        try {
            Candy currentCandy = (Candy)joinPoint.proceed();
            Helper.createCandy(currentCandy);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Around("execution(* Candy.read*(..))")
    public void aroundReadCandyAdvice(ProceedingJoinPoint joinPoint) {
        try {
            Candy currentCandy = (Candy)joinPoint.proceed();
            Helper.readCandy(currentCandy);
        } catch (Throwable e) {
            Message.errorMsg(e.getMessage());
        }
    }

    @Around("execution(* Candy.update*(..))")
    public void aroundUpdateCandyAdvice(ProceedingJoinPoint joinPoint) {
        try {
            Candy currentCandy = (Candy)joinPoint.proceed();
            Helper.updateCandy(currentCandy);
        } catch (Throwable e) {
            Message.errorMsg(e.getMessage());
        }
    }
}

