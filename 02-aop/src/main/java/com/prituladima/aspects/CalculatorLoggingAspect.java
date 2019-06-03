package com.prituladima.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CalculatorLoggingAspect {

    private Log log = LogFactory.getLog(this.getClass());

    @Before("execution(* *.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("The method " + joinPoint.getSignature().getName()
                + "() begins with " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* *.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("The method " + joinPoint.getSignature().getName()
                + "() ends");
    }

    @AfterReturning(
            pointcut = "execution(* *.*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("The method " + joinPoint.getSignature().getName()
                + "() ends with " + result);
    }

    @AfterThrowing(
            pointcut = "execution(* *.*(..))",
            throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.warn("An exception {} has been thrown in {}()", e);
        // joinPoint.getSignature().getName());
    }

    @Around("execution(* *.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(String.format("The method %s() begins with %s", joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())));
        try {
            Object result = joinPoint.proceed();
            log.info(String.format("The method %s() ends with %s", joinPoint.getSignature().getName(), result.toString()));
            return result;
        } catch (IllegalArgumentException e) {
            log.error(String.format("Illegal argument %s in %s()", Arrays.toString(joinPoint.getArgs()) , joinPoint.getSignature().getName()));

            throw e;
        }
    }
}