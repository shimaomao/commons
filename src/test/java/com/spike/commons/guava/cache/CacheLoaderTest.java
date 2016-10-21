package com.spike.commons.guava.cache;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.cache.CacheLoader;
import com.spike.commons.guava.cache.domain.TradeAccount;

/**
 * {@link CacheLoader}的单元测试
 * @author zhoujiagen
 * @see Function
 * @see Supplier
 */
public class CacheLoaderTest {

  @Test
  public void fromFunction() {
    Function<String, TradeAccount> function = new Function<String, TradeAccount>() {
      @Override
      public TradeAccount apply(String input) {
        // 实际获取TradeAccount，这里mock实现
        return new TradeAccount(input, "owner", 0.0d);
      }
    };

    CacheLoader<String, TradeAccount> cacheLoader = CacheLoader.from(function);

    Assert.assertNotNull(cacheLoader);
  }

  @Test
  public void fromSupplier() {
    Supplier<TradeAccount> supplier = new Supplier<TradeAccount>() {
      @Override
      public TradeAccount get() {
        // 直接生成
        return new TradeAccount("<null>", "owner", 0.0d);
      }
    };

    CacheLoader<Object, TradeAccount> cacheLoader = CacheLoader.from(supplier);

    Assert.assertNotNull(cacheLoader);
  }

}
