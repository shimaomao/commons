package com.spike.commons.lang;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Assert;
import org.junit.Test;

import com.spike.commons.lang.domain.Address;

/**
 * {@link BeanUtils}单元测试
 * @author zhoujiagen
 */
public class BeanUtilsTest {

  @Test
  public void populate() throws IllegalAccessException, InvocationTargetException {
    Address address = new Address();
    Assert.assertNull(address.getName());

    Map<String, Object> properties = new HashMap<String, Object>();
    properties.put("name", "nameValue");

    // Map中key对应到JavaBean中字段名称
    BeanUtils.populate(address, properties);

    Assert.assertNotNull(address.getName());

    System.out.println(address);
  }

}
