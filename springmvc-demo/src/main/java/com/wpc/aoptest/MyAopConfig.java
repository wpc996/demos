//package com.wpc.aoptest;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.junit.After;
//import org.junit.Before;
//import org.springframework.aop.Pointcut;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.context.annotation.Bean;
//
//import java.util.Arrays;
//
///**
// * @author wangpeican
// * @date 2023/1/11 19:35
// */
//public class MyAopConfig {
//    @Bean
//    public CalculateController calculateController() {
//        return new CalculateController();
//    }
//
//    @Bean
//    public LogAop logAop() {
//        return new LogAop();
//    }
//
//    @Aspect
//    public class LogAop {
//        //抽取公共的切入点表达式
//        //1、本类引用
//        //2、其他的切面引用
//        @Pointcut("execution(com.wpc.iml.InterfaceTest.*(..))")
//        public void pointCut() {
//        }
//
//
//        @Before(value = "pointCut()")
//        public void logStart(JoinPoint joinPoint) {
//            System.out.println(joinPoint.getSignature().getName() + "方法运行前。。。参数列表是：{" + Arrays.asList(joinPoint.getArgs()) + "}");
//        }
//
//        // 外部切面类引用可以用全类名
//        @After("com.example.studywork.work.aop.LogAop.pointCut()")
//        public void logEnd(JoinPoint joinPoint) {
//            System.out.println(joinPoint.getSignature().getName() + "方法结束。。。");
//        }
//
//        //JoinPoint一定要出现在参数表的第一位
//        @AfterReturning(value = "pointCut()", returning = "obj")
//        public void logReturn(JoinPoint joinPoint, Object obj) {
//            System.out.println(joinPoint.getSignature().getName() + "方法正常返回。。。运行结果是：{" + obj + "}");
//        }
//
//        @AfterThrowing(value = "pointCut()", throwing = "e")
//        public void logxception(JoinPoint joinPoint, Exception e) {
//            System.out.println(joinPoint.getSignature().getName() + "方法异常返回。。。异常结果是：{" + e + "}");
//        }
//    }
//}
