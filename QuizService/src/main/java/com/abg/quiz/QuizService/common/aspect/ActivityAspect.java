package com.abg.quiz.QuizService.common.aspect;

import com.abg.quiz.QuizService.common.annotation.ActivityLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/30/2023
 */
@Aspect
@Component
public class ActivityAspect {
    @Before("execution(* com.abg.quiz.QuizService.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ActivityLog annotation = method.getAnnotation(ActivityLog.class);
        System.out.println("Aspect called for log entry");
        if (annotation != null) {
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = signature.getName();
            long featureId = annotation.featureId().getCode();
            Date timestamp = new Date();
            System.out.println("Class :" + className + " Method :" + methodName + " Feature :" + featureId);
        }
    }
}
