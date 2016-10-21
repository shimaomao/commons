package com.spike.commons.algorithm.bean.util;

/**
 * 时间费用注解<br/>
 * @author zhoujiagen<br/>
 *         Aug 27, 2015 9:54:14 AM
 */
public @interface Expense {
  /** 标记 */
  TAG tag();

  /** 值 */
  String value();

  enum TAG {
    Θ, Ο, Ω
  }
}
