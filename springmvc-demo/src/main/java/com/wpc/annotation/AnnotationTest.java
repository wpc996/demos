package com.wpc.annotation;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author wangpeican
 * @date 2023/1/15 23:15
 */
@Component
@Aspect
public class AnnotationTest {

    @Pointcut("@annotation(com.wpc.annotation.MyAnnotation)")
    public void pc() {
    }

    @Before("pc()")
    public void before() {
        System.out.println("MyAnnotation before...");
    }

    @After("pc()")
    public void after() {
        System.out.println("MyAnnotation after...");
    }


    @Around("pc()")
    public void around() {
        System.out.println("MyAnnotation around...");
    }
}
