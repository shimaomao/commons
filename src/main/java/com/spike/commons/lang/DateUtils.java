package com.spike.commons.lang;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author zhoujiagen
 * @see SimpleDateFormat
 */
public final class DateUtils extends org.apache.commons.lang3.time.DateUtils {
  private static final SimpleDateFormat SIMPLE_DATE_FORMAT_1 = //
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

  /** 当前日期，包括时分秒 */
  public static String now() {
    return SIMPLE_DATE_FORMAT_1.format(new Date());
  }

}
