package com.cloud.annotations;


import cn.hutool.core.lang.copier.SrcToDestCopier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 仅作用于方法
@Retention(RetentionPolicy.RUNTIME) // 在运行时保留注解信息
public @interface RequestType {
    String value() default "";

    String type() default "";
}
