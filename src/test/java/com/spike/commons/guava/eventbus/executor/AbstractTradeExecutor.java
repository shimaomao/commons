package com.spike.commons.guava.eventbus.executor;

import java.util.Date;

import com.google.common.base.Preconditions;
import com.google.common.eventbus.EventBus;
import com.spike.commons.guava.eventbus.domain.TradeAccount;
import com.spike.commons.guava.eventbus.domain.TradeType;

public abstract class AbstractTradeExecutor<BaseTradeEvent> implements
    TradeExecutor<BaseTradeEvent> {

  protected EventBus eventBus;

  public AbstractTradeExecutor(EventBus eventBus) {
    Preconditions.checkNotNull(eventBus);

    this.eventBus = eventBus;
  }

  @Override
  public void execute(TradeAccount tradeAccount, double amount, TradeType tradeType) {
    Date tradeExecutionTime = new Date();
    String message = String.format("Processed trade for %s of amount %n type %s @ %s",//
      tradeAccount.toString(), amount, tradeType, tradeExecutionTime);
    System.out.println(message);

    BaseTradeEvent event = this.constructEvent(tradeExecutionTime, tradeAccount, amount, tradeType);

    eventBus.post(event);
  }

  protected abstract BaseTradeEvent constructEvent(Date tradeExecutionTime,
      TradeAccount tradeAccount, double amount, TradeType tradeType);

}
