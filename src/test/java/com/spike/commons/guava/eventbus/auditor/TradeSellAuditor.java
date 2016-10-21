package com.spike.commons.guava.eventbus.auditor;

import com.google.common.eventbus.EventBus;
import com.spike.commons.guava.eventbus.domain.SellEvent;

public class TradeSellAuditor extends AbstractTradeAuditor<SellEvent> {

  public TradeSellAuditor(EventBus eventBus) {
    super(eventBus);

    eventBus.register(this);
  }

  @Override
  protected void doAudit(SellEvent event) {
    System.out.println("Received sell event: " + event.toString());
  }

  @Override
  public void unregister() {
    eventbus.unregister(this);
  }
}
