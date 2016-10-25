package com.spike.commons.algorithm.bean.dictionary;

/**
 * Description: 发薪名单<br/>
 * Date: 2014-4-27 下午9:51:02
 */
public class Payroll {
  private Integer ID;
  private String name;
  private String address;

  public Payroll(Integer iD, String name, String address) {
    super();
    ID = iD;
    this.name = name;
    this.address = address;
  }

  public Integer getID() {
    return ID;
  }

  public void setID(Integer iD) {
    ID = iD;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Payroll [ID=" + ID + ", name=" + name + ", address=" + address + "]";
  }

}
