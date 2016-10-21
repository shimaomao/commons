package com.spike.commons.annotation.concurrency;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在对象的构造时刻，必须被满足的约束<br/>
 * 示例: bufferCapacity greater than zero...
 * @author zhoujiagen
 */
@Retention(RetentionPolicy.SOURCE)
@Target(value = { ElementType.LOCAL_VARIABLE, ElementType.FIELD })
public @interface InitConstraint {
  String description() default "";
}
