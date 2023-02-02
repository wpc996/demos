package com.wpc.aoptest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wangpeican
 * @date 2023/1/15 23:15
 */
@Component
@Aspect
public class AspectTest {
    @Pointcut("execution(* com.wpc.dao.*.*(..))")
    public void pc() {
    }

    @Before("pc()")
    public void before() {
        System.out.println("Aspect before...");
    }

    @After("pc()")
    public void after() {
        System.out.println("Aspect after...");
    }
}
