package com.spike.commons.guice.example.tutorial.domain;

import java.math.BigDecimal;

public class Receipt {

  public static Receipt forSuccessfulCharge(BigDecimal amount) {
    System.out.println("Successful Charge");
    return new Receipt();
  }

  public static Receipt forDeclinedCharge(String declineMessage) {
    System.out.println("Declined Charge");
    return new Receipt();
  }

  public static Receipt forSystemFailure(String message) {
    System.out.println("System Failure");
    return new Receipt();
  }
}