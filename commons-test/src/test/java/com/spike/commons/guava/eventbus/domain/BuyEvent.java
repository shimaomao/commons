package com.spike.commons.guava.eventbus.domain;

import java.util.Date;

/**
 * 购买事件
 * @author zhoujiagen
 */
public class BuyEvent extends TradeAccountEvent {

  public BuyEvent(double amount, Date tradeExecutionTime, TradeAccount tradeAccount) {
    super(amount, tradeExecutionTime, TradeType.BUY, tradeAccount);
  }

}
