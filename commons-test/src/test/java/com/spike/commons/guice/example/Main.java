package com.spike.commons.guice.example;

import java.math.BigDecimal;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.spike.commons.guice.example.BillingService.CreditCard;
import com.spike.commons.guice.example.BillingService.PizzaOrder;
import com.spike.commons.guice.example.BillingService.Receipt;
import com.spike.commons.guice.example.support.CreditCardProcessor;
import com.spike.commons.guice.example.support.TransactionLog;
import com.spike.commons.guice.example.support.CreditCardProcessor.PaypalCreditCardProcessor;
import com.spike.commons.guice.example.support.TransactionLog.DatabaseTransactionLog;

public class Main {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new Module());

    BillingService billingService = injector.getInstance(BillingService.class);

    PizzaOrder order = new PizzaOrder(new BigDecimal(100));
    CreditCard creditCard = new CreditCard("1234", 11, 2010);
    Receipt receipt = billingService.chargeOrder(order, creditCard);

    System.out.println(receipt);
  }

  public static class Module extends AbstractModule {

    @Override
    protected void configure() {
      // 接口-实现绑定
      bind(TransactionLog.class).to(DatabaseTransactionLog.class);
      bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
      bind(BillingService.class).to(BillingServiceImpl.class);
    }

  }

}
