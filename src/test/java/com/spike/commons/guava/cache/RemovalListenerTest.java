package com.spike.commons.guava.cache;

import java.util.concurrent.ExecutorService;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners;
import com.google.common.util.concurrent.MoreExecutors;
import com.spike.commons.guava.cache.domain.TradeAccount;

/**
 * {@link RemovalListener}的单元测试
 * @author zhoujiagen
 */
public class RemovalListenerTest {

  @Test
  public void regular() {
    RemovalListener<String, TradeAccount> removalListener = new TradeAccountRemovalListener();

    Cache<String, TradeAccount> cache =
        CacheBuilder.newBuilder().removalListener(removalListener).build();

    Assert.assertNotNull(cache);
  }

  @Test
  public void runInExecutors() {
    ExecutorService executorService = MoreExecutors.newDirectExecutorService();

    RemovalListener<String, TradeAccount> removalListener = new TradeAccountRemovalListener();

    RemovalListener<String, TradeAccount> asyncRemovalListener = //
        RemovalListeners.asynchronous(removalListener, executorService);

    // 在其他线程池中执行
    Cache<String, TradeAccount> cache =
        CacheBuilder.newBuilder().removalListener(asyncRemovalListener).build();

    Assert.assertNotNull(cache);
  }

}
