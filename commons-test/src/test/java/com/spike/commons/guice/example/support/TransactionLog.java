package com.spike.commons.guice.example.support;

import com.spike.commons.guice.example.support.CreditCardProcessor.ChargeResult;
import com.spike.commons.guice.example.support.CreditCardProcessor.UnreachableException;

public interface TransactionLog {

  void logChargeResult(ChargeResult result);

  void logConnectException(UnreachableException e);

  class DatabaseTransactionLog implements TransactionLog {

    @Override
    public void logChargeResult(ChargeResult result) {
      System.out.println(result.toString());
    }

    @Override
    public void logConnectException(UnreachableException e) {
      System.out.println(e.getMessage());
    }
  }
}