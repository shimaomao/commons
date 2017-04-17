package com.spike.commons.guice.example.tutorial.domain;

public class ChargeResult {

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