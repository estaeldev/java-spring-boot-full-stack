package com.project.learn_aop.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class CommonPointcutConfig {

    @Pointcut("execution(* com.project.learn_aop.aop.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    @Pointcut("@annotation(com.project.learn_aop.aop.aspects.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
    
}
