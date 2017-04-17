package com.spike.commons.guice.example.tutorial.support;

import java.math.BigDecimal;

import com.spike.commons.guice.example.tutorial.domain.ChargeResult;
import com.spike.commons.guice.example.tutorial.domain.CreditCard;

public interface CreditCardProcessor {
  ChargeResult charge(CreditCard creditCard, BigDecimal amount) throws UnreachableException;
}