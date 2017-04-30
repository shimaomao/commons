package com.spike.commons.guice.example;

import java.math.BigDecimal;

public interface BillingService {

  Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);

  class CreditCard {

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

  class PizzaOrder {
    private BigDecimal amount;

    public PizzaOrder(BigDecimal amount) {
      this.amount = amount;
    }

    public BigDecimal getAmount() {
      return amount;
    }

    public void setAmount(BigDecimal amount) {
      this.amount = amount;
    }
  }

  class Receipt {

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
}
