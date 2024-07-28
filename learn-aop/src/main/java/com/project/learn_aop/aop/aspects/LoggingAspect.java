package com.project.learn_aop.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Before("com.project.learn_aop.aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect - {} is called with arguments: {}", joinPoint, joinPoint.getArgs());
    }

    @After("com.project.learn_aop.aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - {} is called has executed", joinPoint);
    }

    @AfterThrowing(
        pointcut = "com.project.learn_aop.aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()", 
        throwing = "exception"
    )
    public void logMethodCallAfterThrowingExecution(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing Aspect - {} is called has thrown an exception", joinPoint, exception);
    }

    @AfterReturning(
        pointcut = "com.project.learn_aop.aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()", 
        returning = "resultValue"
    )
    public void logMethodCallAfterReturningExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info("AfterReturning Aspect - {} is called has returned {}", joinPoint, resultValue);
    }
    

}
