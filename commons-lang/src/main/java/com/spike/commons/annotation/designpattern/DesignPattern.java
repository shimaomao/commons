package com.spike.commons.annotation.designpattern;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.spike.commons.annotation.designpattern.DesignPatternContants.Pattern;

/**
 * 设计模式文档性质的注解
 * @author zhoujiagen
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target(value = { ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
    ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE,
    ElementType.PACKAGE })
public @interface DesignPattern {
  Pattern value() default Pattern._;

  String description() default "";
}
