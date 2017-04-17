package com.spike.commons.guice.example.tutorial.support;

import java.math.BigDecimal;

import com.spike.commons.guice.example.tutorial.domain.ChargeResult;
import com.spike.commons.guice.example.tutorial.domain.CreditCard;

public class PaypalCreditCardProcessor implements CreditCardProcessor {
  @Override
  public ChargeResult charge(CreditCard creditCard, BigDecimal amount) throws UnreachableException {
    return new ChargeResult();
  }
}