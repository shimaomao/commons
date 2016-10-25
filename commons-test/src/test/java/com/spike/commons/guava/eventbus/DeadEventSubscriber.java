package com.spike.commons.guava.eventbus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * 订阅取消订阅事件
 * @author zhoujiagen
 */
public class DeadEventSubscriber {
  public DeadEventSubscriber(EventBus eventBus) {
    eventBus.register(this);
  }

  @Subscribe
  public void handleUnsubsribeEvent(DeadEvent deadEvent) {
    System.out.println("No subscribers for " + deadEvent.getEvent());
  }

}
