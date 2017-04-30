package com.spike.commons.guice.example;

import javax.inject.Inject;

import com.spike.commons.guice.example.support.CreditCardProcessor;
import com.spike.commons.guice.example.support.TransactionLog;
import com.spike.commons.guice.example.support.CreditCardProcessor.ChargeResult;
import com.spike.commons.guice.example.support.CreditCardProcessor.UnreachableException;

public class BillingServiceImpl implements BillingService {

  private final CreditCardProcessor processor;
  private final TransactionLog transactionLog;

  // 注入
  @Inject
  public BillingServiceImpl(CreditCardProcessor processor, TransactionLog transactionLog) {
    this.processor = processor;
    this.transactionLog = transactionLog;
  }

  @Override
  public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {

    try {
      ChargeResult result = processor.charge(creditCard, order.getAmount());
      transactionLog.logChargeResult(result);

      return result.wasSuccessful() ? Receipt.forSuccessfulCharge(order.getAmount()) : Receipt
          .forDeclinedCharge(result.getDeclineMessage());
    } catch (UnreachableException e) {
      transactionLog.logConnectException(e);
      return Receipt.forSystemFailure(e.getMessage());
    }
  }
}
