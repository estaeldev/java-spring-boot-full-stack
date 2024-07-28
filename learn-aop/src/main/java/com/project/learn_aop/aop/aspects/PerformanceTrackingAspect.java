package com.project.learn_aop.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());

    // @Around("execution(* com.project.learn_aop.aop.*.*.*(..))")
    @Around("com.project.learn_aop.aop.aspects.CommonPointcutConfig.trackTimeAnnotation")
    public Object findExecutionTime(ProceedingJoinPoint point) throws Throwable {
        long starTimeMillis = System.currentTimeMillis();

        Object returnValue = point.proceed();

        long stopTimeMillis = System.currentTimeMillis();

        long duration = starTimeMillis - stopTimeMillis;

        logger.info("Around Aspect - {} Method execute in {} ms", point, duration);

        return returnValue;
    }
    
}
