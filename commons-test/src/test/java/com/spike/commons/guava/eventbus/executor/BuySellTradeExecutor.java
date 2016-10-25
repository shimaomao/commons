package com.spike.commons.guava.eventbus.executor;

import java.util.Date;

import com.google.common.eventbus.EventBus;
import com.spike.commons.exception.ExceptionUtils;
import com.spike.commons.guava.eventbus.domain.BaseTradeEvent;
import com.spike.commons.guava.eventbus.domain.BuyEvent;
import com.spike.commons.guava.eventbus.domain.SellEvent;
import com.spike.commons.guava.eventbus.domain.TradeAccount;
import com.spike.commons.guava.eventbus.domain.TradeType;

public class BuySellTradeExecutor extends AbstractTradeExecutor<BaseTradeEvent> {

  public BuySellTradeExecutor(EventBus eventBus) {
    super(eventBus);
  }

  @Override
  protected BaseTradeEvent constructEvent(Date tradeExecutionTime, TradeAccount tradeAccount,
      double amount, TradeType tradeType) {
    if (TradeType.BUY.equals(tradeType)) {
      return new BuyEvent(amount, tradeExecutionTime, tradeAccount);
    } else if (TradeType.SELL.equals(tradeType)) {
      return new SellEvent(amount, tradeExecutionTime, tradeAccount);
    } else {
      throw ExceptionUtils.unsupport("不支持的交易类型！");
    }
  }

}
