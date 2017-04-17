package com.spike.commons.guice.example.tutorial.support;

import com.spike.commons.guice.example.tutorial.domain.ChargeResult;

public interface TransactionLog {

  void logChargeResult(ChargeResult result);

  void logConnectException(UnreachableException e);

}