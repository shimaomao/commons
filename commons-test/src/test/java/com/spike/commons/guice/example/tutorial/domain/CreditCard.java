package com.spike.commons.guice.example.tutorial.domain;

public class CreditCard {

  private String no;
  private int month;
  private int year;

  public CreditCard(String no, int month, int year) {
    this.no = no;
    this.month = month;
    this.year = year;
  }

  public String getNo() {
    return no;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

}