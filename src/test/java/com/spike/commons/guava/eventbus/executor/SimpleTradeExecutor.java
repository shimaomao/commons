package com.spike.commons.guava.eventbus.executor;

import java.util.Date;

import com.google.common.eventbus.EventBus;
import com.spike.commons.guava.eventbus.domain.TradeAccount;
import com.spike.commons.guava.eventbus.domain.TradeAccountEvent;
import com.spike.commons.guava.eventbus.domain.TradeType;

/**
 * 事件发布示例
 * @author zhoujiagen
 */
public class SimpleTradeExecutor extends AbstractTradeExecutor<TradeAccountEvent> {

  public SimpleTradeExecutor(EventBus eventBus) {
    super(eventBus);
  }

  @Override
  public TradeAccountEvent constructEvent(Date tradeExecutionTime, TradeAccount tradeAccount,
      double amount, TradeType tradeType) {
    return new TradeAccountEvent(amount, tradeExecutionTime, tradeType, tradeAccount);
  }

}
