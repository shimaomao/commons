package com.spike.commons.guice.example.tutorial;

import java.math.BigDecimal;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.spike.commons.guice.example.tutorial.domain.CreditCard;
import com.spike.commons.guice.example.tutorial.domain.PizzaOrder;
import com.spike.commons.guice.example.tutorial.domain.Receipt;
import com.spike.commons.guice.example.tutorial.support.CreditCardProcessor;
import com.spike.commons.guice.example.tutorial.support.DatabaseTransactionLog;
import com.spike.commons.guice.example.tutorial.support.PaypalCreditCardProcessor;
import com.spike.commons.guice.example.tutorial.support.TransactionLog;

public class Main {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new ApplicationModule());

    BillingService billingService = injector.getInstance(BillingService.class);

    PizzaOrder order = new PizzaOrder(new BigDecimal(100));
    CreditCard creditCard = new CreditCard("1234", 11, 2010);
    Receipt receipt = billingService.chargeOrder(order, creditCard);

    System.out.println(receipt);
  }

  public static class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
      // 接口-实现绑定
      bind(TransactionLog.class).to(DatabaseTransactionLog.class);
      bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
      bind(BillingService.class).to(BillingServiceImpl.class);
    }

  }

}
