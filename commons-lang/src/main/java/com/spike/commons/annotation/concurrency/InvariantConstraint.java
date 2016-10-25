package com.spike.commons.annotation.concurrency;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在每个公共方法的起始处和结束处都需要保持为真<br/>
 * 示例: x, y are valid screen coordinates...
 * @author zhoujiagen
 */
@Retention(RetentionPolicy.SOURCE)
@Target(value = { ElementType.METHOD })
public @interface InvariantConstraint {
  String description() default "";
}
