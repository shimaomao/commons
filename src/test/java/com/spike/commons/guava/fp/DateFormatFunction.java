package com.spike.commons.guava.fp;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.base.Function;

/**
 * 日期格式化函数，输入{@link Date}，输出{@link String}
 * @author zhoujiagen
 */
public class DateFormatFunction implements Function<Date, String> {

  @Override
  public String apply(Date input) {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    return format.format(input);
  }

}
