package com.spike.commons.guava.eventbus.executor;

import com.spike.commons.guava.eventbus.domain.TradeAccount;
import com.spike.commons.guava.eventbus.domain.TradeType;

public interface TradeExecutor<BaseTradeEvent> {

  /**
   * 执行交易
   * @param tradeAccount 账户
   * @param amount 金额
   * @param tradeType 交易类型
   */
  public void execute(TradeAccount tradeAccount, double amount, TradeType tradeType);
}
