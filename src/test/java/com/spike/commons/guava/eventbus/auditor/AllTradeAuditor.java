package com.spike.commons.guava.eventbus.auditor;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import com.spike.commons.guava.eventbus.domain.BaseTradeEvent;
import com.spike.commons.guava.eventbus.domain.BuyEvent;
import com.spike.commons.guava.eventbus.domain.SellEvent;
import com.spike.commons.guava.eventbus.domain.TradeType;

public class AllTradeAuditor extends AbstractTradeAuditor<BaseTradeEvent> {

  public AllTradeAuditor(EventBus eventBus) {
    super(eventBus);
  }

  @Override
  protected void doAudit(BaseTradeEvent event) {
    TradeType tradeType = null;

    if (event instanceof BuyEvent) {
      tradeType = TradeType.BUY;
    } else if (event instanceof SellEvent) {
      tradeType = TradeType.SELL;
    }

    System.out.println("Receive [" + tradeType + "] event");
  }

  /**
   * <pre>
   * 筛选出{@link TradeType#BUY}的事件
   * </pre>
   * @return
   */
  public List<BuyEvent> buyEvents() {
    List<BuyEvent> result = Lists.<BuyEvent> newArrayList();

    for (BaseTradeEvent event : events) {
      if (event instanceof BuyEvent) {
        result.add((BuyEvent) event);// cast
      }
    }

    return result;
  }

  @Override
  public void unregister() {
    eventbus.unregister(this);
  }
}
