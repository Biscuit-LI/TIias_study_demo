package com.jerry.tilas.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//动态代理（依赖注入）
@Aspect//切面类
@Order(1)//等级
@Slf4j
@Component
public class RecordTimeAspect {
    //连接点——切入点——目标对象——通知——切面
    @Pointcut("execution(* com.jerry.tilas.service.*.*(..))")//切入点表达式
    public void pt() {}

    //环绕（需指定运行位置 ProcessdingJoinPoint->process）
    @Around("execution(* com.jerry.tilas.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
            long beginTime = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            log.info("{}用时{}ms",joinPoint.getSignature().getName(),(endTime - beginTime));
            return result;
    }
    //之前运行
    @Before("pt()")
    public void before(JoinPoint joinPoint) throws Throwable {
        log.info("before");
    }
    //之后运行
    @After("execution(* com.jerry.tilas.service.*.*(..))")
    public void after(JoinPoint joinPoint) throws Throwable {
        log.info("after");
    }
    //异常后不会运行
    @AfterReturning("execution(* com.jerry.tilas.service.*.*(..))")
    public void afterReturning(JoinPoint joinPoint) throws Throwable {
        log.info("afterReturning");
    }
    //异常后才运行
    @AfterThrowing("execution(* com.jerry.tilas.service.*.*(..))")
    public void afterThrowing(JoinPoint joinPoint){
        log.info("afterThrowing");
    }

}
