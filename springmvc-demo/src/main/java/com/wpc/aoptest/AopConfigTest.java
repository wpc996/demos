package com.wpc.aoptest;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author wangpeican
 * @date 2023/1/11 20:21
 */
@Component
public class AopConfigTest {
    //设置切入点，要求配置在方法上方
//    @Pointcut("execution(* com.wpc.dao.BookDao.update())")
//    private void pt(){}

    //设置在切入点pt()的前面运行当前操作（前置通知）
//    @Before("pt()")
    public void before(){
        System.out.println("AopConfigTest before.....");
    }

    //设置在切入点pt()的执行后运行当前操作（后置通知）
//    @After("pt()")
    public void after() {
        System.out.println("AopConfigTest after.....");
    }

    public void around() {
        System.out.println("around.....");
    }

    public String afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature());
        System.out.println(result);
        System.out.println("afterReturning.....");
        return "afterReturning";
    }

    public void afterThrow(JoinPoint joinPoint, Throwable e) {
        System.out.println(joinPoint.getClass());
        System.out.println("afterThrow.....");
        System.out.println(e.getMessage());
    }

}