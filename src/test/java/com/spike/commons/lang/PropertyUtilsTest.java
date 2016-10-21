package com.spike.commons.lang;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Before;
import org.junit.Test;

import com.spike.commons.lang.domain.Address;
import com.spike.commons.lang.domain.Employee;

/**
 * {@link PropertyUtils}单元测试
 * @author zhoujiagen
 */
public class PropertyUtilsTest {

  private Employee employee;

  @Before
  public void setUp() {
    employee = new Employee();
    employee.setFirstName("firstName");
    employee.setLastName("lastName");

    Employee employee2 = new Employee();
    employee.setSubordinate(0, employee);
    employee.setSubordinate(1, employee2);

    Address address1 = new Address();
    address1.setName("name");
    employee.setAddress("type1", address1);
  }

  @Test
  public void simple() throws IllegalAccessException, InvocationTargetException,
      NoSuchMethodException {
    // get
    Object value = PropertyUtils.getSimpleProperty(employee, "firstName");
    assertNotNull(value);
    System.err.println(value);

    // set
    PropertyUtils.setSimpleProperty(employee, "firstName", "firstName2");
    value = PropertyUtils.getSimpleProperty(employee, "firstName");
    assertNotNull(value);
    System.err.println(value);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void indexed() throws IllegalAccessException, InvocationTargetException,
      NoSuchMethodException {
    Object value = PropertyUtils.getIndexedProperty(employee, "subordinate", 0);
    assertNotNull(value);
    System.err.println(value);

    value = PropertyUtils.getIndexedProperty(employee, "subordinate", 1);
    assertNotNull(value);
    System.err.println(value);

    value = PropertyUtils.getIndexedProperty(employee, "subordinate", 2);
    System.err.println(value);
  }

  @Test
  public void mapped() throws IllegalAccessException, InvocationTargetException,
      NoSuchMethodException {
    Object value = PropertyUtils.getMappedProperty(employee, "typeAddressMap", "type1");
    assertNotNull(value);
    System.err.println(value);
  }

  /**
   * 嵌套属性
   * @see Employee#getAddress(String)
   */
  @Test
  public void nestedProperty() throws IllegalAccessException, InvocationTargetException,
      NoSuchMethodException {
    // 使用了getAddress方法
    Object value = PropertyUtils.getNestedProperty(employee, "address(type1).name");
    assertNotNull(value);
    System.err.println(value);
  }

}
