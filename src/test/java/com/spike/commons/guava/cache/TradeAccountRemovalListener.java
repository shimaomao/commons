package com.spike.commons.guava.cache;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.spike.commons.guava.cache.domain.TradeAccount;

/**
 * 自定义{@link RemovalListener}实现
 * @author zhoujiagen
 */
public class TradeAccountRemovalListener implements RemovalListener<String, TradeAccount> {

  @Override
  public void onRemoval(RemovalNotification<String, TradeAccount> notification) {

    // 键、值和原因
    System.err.println("REMOVAL: " + notification.getKey() + "=" + notification.getValue() //
        + ", caused by " + notification.getCause());
  }

}
