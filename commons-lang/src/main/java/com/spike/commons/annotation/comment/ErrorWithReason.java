package com.spike.commons.annotation.comment;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 带错误原因的注解
 * @author zhoujiagen
 */
@Retention(RetentionPolicy.SOURCE)
@Target(value = { ElementType.LOCAL_VARIABLE, ElementType.FIELD, ElementType.TYPE,
    ElementType.METHOD })
public @interface ErrorWithReason {
  String[] description() default "";
}
