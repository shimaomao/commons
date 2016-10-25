package com.spike.commons.lang.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试用实体1
 * @author zhoujiagen
 */
public class Employee {
  // 简单属性
  private String firstName;
  private String lastName;

  // 映射属性
  Map<String, Address> typeAddressMap = new HashMap<String, Address>();

  // 序列属性
  List<Employee> subordinate = new ArrayList<Employee>();

  public Employee() {
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Address getAddress(String type) {
    return typeAddressMap.get(type);
  }

  public void setAddress(String type, Address address) {
    typeAddressMap.put(type, address);
  }

  public Employee getSubordinate(int index) {
    return subordinate.get(index);
  }

  public void setSubordinate(int index, Employee employee) {
    subordinate.add(index, employee);
  }
}
