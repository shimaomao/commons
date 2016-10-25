package com.spike.commons.lang;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.MethodUtils;
import org.junit.Test;

import com.spike.commons.lang.domain.Address;

/**
 * {@link MethodUtils}单元测试
 * @author zhoujiagen
 */
public class MethodUtilsTest {

  @Test
  public void invokeMethod() throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException {
    Address address = new Address();
    address.setName("name1");

    Object value = MethodUtils.invokeExactMethod(address, "getName", null);
    System.err.println(value);
  }

}
