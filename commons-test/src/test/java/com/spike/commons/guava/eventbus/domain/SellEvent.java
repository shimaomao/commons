package com.spike.commons.guava.eventbus.domain;

import java.util.Date;

/**
 * 卖出事件
 * @author zhoujiagen
 */
public class SellEvent extends TradeAccountEvent {

  public SellEvent(double amount, Date tradeExecutionTime, TradeAccount tradeAccount) {
    super(amount, tradeExecutionTime, TradeType.SELL, tradeAccount);
  }

}
