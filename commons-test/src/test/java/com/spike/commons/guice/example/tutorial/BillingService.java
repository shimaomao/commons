package com.spike.commons.guice.example.tutorial;

import com.spike.commons.guice.example.tutorial.domain.CreditCard;
import com.spike.commons.guice.example.tutorial.domain.PizzaOrder;
import com.spike.commons.guice.example.tutorial.domain.Receipt;

public interface BillingService {

  Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);

}
