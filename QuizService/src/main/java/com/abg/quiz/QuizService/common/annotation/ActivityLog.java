package com.abg.quiz.QuizService.common.annotation;


import com.abg.quiz.QuizService.common.enums.AdminFeatureEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityLog {
    AdminFeatureEnum featureId();
}
