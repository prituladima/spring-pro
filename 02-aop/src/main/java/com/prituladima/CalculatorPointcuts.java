package com.prituladima;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalculatorPointcuts {
    @Pointcut("within(com.prituladima.ArithmeticCalculator+)")
    public void arithmeticOperation() {}
    @Pointcut("within(com.prituladima.UnitCalculator+)")
    public void unitOperation() {}
    @Pointcut("arithmeticOperation() || unitOperation()")
    public void loggingOperation() {}
}