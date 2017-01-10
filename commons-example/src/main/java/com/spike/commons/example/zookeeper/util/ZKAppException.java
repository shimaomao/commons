package com.spike.commons.example.zookeeper.util;

public class ZKAppException extends Exception {
  private static final long serialVersionUID = 1L;

  private String errorCode = "10000";

  public ZKAppException(String message) {
    super(message);
  }

  public ZKAppException(String errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public ZKAppException(String message, Throwable cause) {
    super(message, cause);
  }

  public ZKAppException(String errorCode, String message, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  public ZKAppException(Throwable cause) {
    super(cause);
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  @Override
  public String toString() {
    return "ZKAppException [errorCode=" + errorCode + ", message=" + getMessage() + "]";
  }

}
