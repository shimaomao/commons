package com.spike.commons.lang;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author zhoujiagen
 * @see SimpleDateFormat
 */
public final class DateUtils extends org.apache.commons.lang3.time.DateUtils {
  public static final String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
  public static final String DATE_FORMAT_YMD_PATTERN = "yyyy-MM-dd";

  public static final SimpleDateFormat DEFAULT_DATE_FORMAT = //
      new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN);

  /** 当前日期，包括时分秒 */
  public static String now() {
    return DEFAULT_DATE_FORMAT.format(new Date());
  }

  public static String now(String dateFormatPattern) {
    return new SimpleDateFormat(dateFormatPattern).format(new Date());
  }
}
