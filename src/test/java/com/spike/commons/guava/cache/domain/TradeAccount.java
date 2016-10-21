package com.spike.commons.guava.cache.domain;

import com.google.common.base.MoreObjects;

public class TradeAccount {
  private String id;
  private String owner;
  private double balance;

  public TradeAccount() {
  }

  public TradeAccount(String id, String owner, double balance) {
    this.id = id;
    this.owner = owner;
    this.balance = balance;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {

    return MoreObjects.toStringHelper(this)//
        .omitNullValues()//
        .add("id", id)//
        .add("owner", owner)//
        .add("balance", balance)//
        .toString();
  }

}