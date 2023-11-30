package com.brainstation23.admin.common.annotations;

import com.brainstation23.admin.domain.enums.AdminFeatureEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityLog {
    AdminFeatureEnum featureId();
}
