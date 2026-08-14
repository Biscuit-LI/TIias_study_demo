package com.jerry.tilas.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//动态代理（依赖注入）
@Aspect//切面类
@Order(5)//等级
@Slf4j
@Component
public class DemoAspect {
    //连接点——切入点——目标对象——通知——切面
    @Pointcut("execution(* com.jerry.tilas.service.*.*(..))")//切入点表达式
    public void pt() {}

    //环绕（需指定运行位置 ProceedingJoinPoint->process）
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

    //切入点表达式->接口实现所有
    @Before("execution(* com.jerry.tilas.service.ClazzService.*(..))")
    public void text(){
        log.info("text");
    }
    //注解标记-point演示获取信息
    @Before("@annotation(com.jerry.tilas.anno.LogOperation)")
    public void text2(JoinPoint joinPoint){
        log.info("text");
        //获取目标对象
        Object obj=joinPoint.getTarget();
        log.info("obj={}",obj);
        //获取目标类名
        String targetName=joinPoint.getTarget().getClass().getName();
        log.info("targetName={}",targetName);
        //获取方法名
        String methodName=joinPoint.getSignature().getName();
        log.info("methodName={}",methodName);
        //获取参数
        Object[] args=joinPoint.getArgs();
        log.info("args={}",args);
    }
}
