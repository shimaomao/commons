package com.spike.commons.guice.example.tutorial.domain;

import java.math.BigDecimal;

public class PizzaOrder {
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