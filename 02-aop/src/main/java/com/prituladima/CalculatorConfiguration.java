package com.prituladima;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class CalculatorConfiguration {

//    @Bean
//    public ArithmeticCalculator arithmeticCalculator() {
//        return new ArithmeticCalculatorImpl();
//    }
//
//    @Bean
//    public UnitCalculator unitCalculator() {
//        return new UnitCalculatorImpl();
//    }
}
