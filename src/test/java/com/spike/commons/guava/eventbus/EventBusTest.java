package com.spike.commons.guava.eventbus;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import com.google.common.util.concurrent.MoreExecutors;
import com.spike.commons.guava.eventbus.auditor.SimpleTradeAuditor;
import com.spike.commons.guava.eventbus.auditor.TradeAuditor;
import com.spike.commons.guava.eventbus.domain.BaseTradeEvent;
import com.spike.commons.guava.eventbus.domain.TradeAccount;
import com.spike.commons.guava.eventbus.domain.TradeAccountEvent;
import com.spike.commons.guava.eventbus.domain.TradeType;
import com.spike.commons.guava.eventbus.executor.SimpleTradeExecutor;

/**
 * {@link EventBus}的单元测试 {@link EventBus}是轻量级的<strong>进程内</strong>订阅/发布通信实现
 * @author zhoujiagen
 */
public class EventBusTest {
  private static final Logger LOG = Logger.getLogger(EventBusTest.class.getCanonicalName());

  @Test
  public void createEventBus() {
    EventBus eventBus = new EventBus();
    Assert.assertEquals("default", eventBus.identifier());

    eventBus = new EventBus("somename");
    Assert.assertEquals("somename", eventBus.identifier());

    // 订阅者异常处理器
    SubscriberExceptionHandler exceptionHandler = new SubscriberExceptionHandler() {
      @Override
      public void handleException(Throwable exception, SubscriberExceptionContext context) {
        LOG.log(Level.WARNING, "订阅异常", exception);

        LOG.info("EventBus: " + context.getEventBus().identifier());
        LOG.info("Event: " + context.getEvent().toString());
        LOG.info("Subscriber: " + context.getSubscriber().toString());
        LOG.info("Subsriber Method: " + context.getSubscriberMethod().toString());
      }
    };

    eventBus = new EventBus(exceptionHandler);
    Assert.assertEquals("default", eventBus.identifier());
  }

  /**
   * <pre>
   * 异步的事件总线
   * </pre>
   */
  @Test
  public void createAsyncEventBus() {
    Executor executor = MoreExecutors.directExecutor();
    AsyncEventBus asyncEventBus = new AsyncEventBus(executor);

    Assert.assertEquals("default", asyncEventBus.identifier());
  }

  @Test
  public void publish_subscribe() throws IOException {
    EventBus eventBus = new EventBus(TradeAccountEvent.class.getCanonicalName());

    // 交易执行者
    SimpleTradeExecutor executor = new SimpleTradeExecutor(eventBus);

    // 交易审计者(注册和订阅)
    new SimpleTradeAuditor(eventBus);

    TradeAccount tradeAccount = new TradeAccount("id", "owner", 200.d);

    // 执行(发布)
    executor.execute(tradeAccount, 100.0d, TradeType.BUY);

    // 等待
    // System.in.read();
  }

  /**
   * <pre>
   * 事件层次和审计者层次
   * </pre>
   * @see BaseTradeEvent
   * @see TradeAuditor
   */
  @Test
  public void fineGrainedEventHandler() {

  }

  @Test
  public void dependencyInjectionWithEventBus() {

  }

}
