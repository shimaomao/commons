package com.spike.commons.guice.example.tutorial.support;

import com.spike.commons.guice.example.tutorial.domain.ChargeResult;

public class DatabaseTransactionLog implements TransactionLog {

  @Override
  public void logChargeResult(ChargeResult result) {
    System.out.println(result.toString());
  }

  @Override
  public void logConnectException(UnreachableException e) {
    System.out.println(e.getMessage());
  }
}