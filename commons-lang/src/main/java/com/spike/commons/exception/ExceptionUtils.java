package com.spike.commons.exception;

/**
 * 异常工具类
 * @author zhoujiagen
 */
public final class ExceptionUtils extends org.apache.commons.lang3.exception.ExceptionUtils {

  /**
   * 非法参数异常
   * @param message
   * @return
   */
  public static final IllegalArgumentException argumentException(String message) {
    return new IllegalArgumentException(message);
  }

  /**
   * 非法状态异常
   * @param message
   * @return
   */
  public static IllegalStateException stateException(String message) {
    return new IllegalStateException(message);
  }

  /**
   * 不支持的操作异常
   * @param message
   * @return
   */
  public static UnsupportedOperationException unsupport(String message) {
    return new UnsupportedOperationException(message);
  }

}
