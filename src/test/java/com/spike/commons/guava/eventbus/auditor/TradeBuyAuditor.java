package com.spike.commons.guava.eventbus.auditor;

import com.google.common.eventbus.EventBus;
import com.spike.commons.guava.eventbus.domain.BuyEvent;

public class TradeBuyAuditor extends AbstractTradeAuditor<BuyEvent> {

  public TradeBuyAuditor(EventBus eventBus) {
    super(eventBus);

    eventBus.register(this);
  }

  @Override
  public void doAudit(BuyEvent event) {

    System.out.println("Received buy event: " + event.toString());
  }

  @Override
  public void unregister() {
    eventbus.unregister(this);
  }
}
