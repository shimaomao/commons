package com.spike.commons.algorithm.bean.util;

/**
 * Description: 数据结构异常<br/>
 * Date: 2014-4-26 下午4:22:37<br/>
 * 建议使用断言(1)assert condition-expression : "comments";<br/>
 * (2)org.junit.Assert.assertTrue("comments", condition);
 */
@Deprecated
public class DSException extends Exception {
  private static final long serialVersionUID = -1786022238051626656L;

  public DSException(String message) {
    super(message);
  }
}
