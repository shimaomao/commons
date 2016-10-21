package com.spike.commons.guava.eventbus.domain;

import java.util.Date;

import com.google.common.base.MoreObjects;

import static com.google.common.base.Preconditions.*;

/**
 * 账户交易事件
 * @author zhoujiagen
 */
public class TradeAccountEvent implements BaseTradeEvent {
  private double amount;
  private Date tradeExecutionTime;
  private TradeType tradeType;
  private TradeAccount tradeAccount;

  public TradeAccountEvent(double amount, Date tradeExecutionTime, TradeType tradeType,
      TradeAccount tradeAccount) {
    checkArgument(amount > 0.0, "Trade can't be less than zero");
    this.amount = amount;

    this.tradeExecutionTime = checkNotNull(tradeExecutionTime, "ExecutionTime can't be null");
    this.tradeType = checkNotNull(tradeType, "TradeType can't be null");
    this.tradeAccount = checkNotNull(tradeAccount, "Account can't be null");
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Date getTradeExecutionTime() {
    return tradeExecutionTime;
  }

  public void setTradeExecutionTime(Date tradeExecutionTime) {
    this.tradeExecutionTime = tradeExecutionTime;
  }

  public TradeType getTradeType() {
    return tradeType;
  }

  public void setTradeType(TradeType tradeType) {
    this.tradeType = tradeType;
  }

  public TradeAccount getTradeAccount() {
    return tradeAccount;
  }

  public void setTradeAccount(TradeAccount tradeAccount) {
    this.tradeAccount = tradeAccount;
  }

  @Override
  public String toString() {

    return MoreObjects.toStringHelper(this)//
        .omitNullValues()//
        .add("amount", amount)//
        .add("tradeExecutionTime", tradeExecutionTime)//
        .add("tradeType", tradeType)//
        .add("tradeAccount", tradeAccount.toString())//
        .toString();
  }
}
