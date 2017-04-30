package com.spike.commons.guice.example.support;

import java.math.BigDecimal;

import com.spike.commons.guice.example.BillingService.CreditCard;

public interface CreditCardProcessor {
  ChargeResult charge(CreditCard creditCard, BigDecimal amount) throws UnreachableException;

  class UnreachableException extends Exception {
    private static final long serialVersionUID = 1L;
  }

  class ChargeResult {

    private boolean wasSuccessful;
    private String declineMessage;

    public boolean wasSuccessful() {
      return wasSuccessful;
    }

    public String getDeclineMessage() {
      return declineMessage;
    }

    public void setWasSuccessful(boolean wasSuccessful) {
      this.wasSuccessful = wasSuccessful;
    }

    public void setDeclineMessage(String declineMessage) {
      this.declineMessage = declineMessage;
    }

  }

  class PaypalCreditCardProcessor implements CreditCardProcessor {
    @Override
    public ChargeResult charge(CreditCard creditCard, BigDecimal amount)
        throws UnreachableException {
      return new ChargeResult();
    }

  }
}