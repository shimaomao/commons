package com.spike.commons.lang.domain;

/**
 * 测试用实体2
 * @author zhoujiagen
 */
public class Address {
  private String name;

  public Address() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Address [name=" + name + "]";
  }

}
