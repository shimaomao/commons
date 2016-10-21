package com.spike.commons.guava.eventbus.auditor;

import com.google.common.eventbus.EventBus;
import com.spike.commons.guava.eventbus.domain.TradeAccountEvent;

/**
 * 事件订阅示例
 * @author zhoujiagen
 */
public class SimpleTradeAuditor extends AbstractTradeAuditor<TradeAccountEvent> {

  public SimpleTradeAuditor(EventBus eventBus) {
    super(eventBus);
    // 注册
    eventBus.register(this);
  }

  @Override
  protected void doAudit(TradeAccountEvent event) {

    System.out.println("Received trade event: " + event.toString());
  }

  @Override
  public void unregister() {
    eventbus.unregister(this);
  }
}
