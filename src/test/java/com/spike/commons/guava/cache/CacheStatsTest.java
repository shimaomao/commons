package com.spike.commons.guava.cache;

import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.spike.commons.guava.cache.domain.TradeAccount;

/**
 * {@link CacheStats}的单元测试 缓存的统计信息
 * @author zhoujiagen
 */
public class CacheStatsTest {
  private CacheLoader<String, TradeAccount> cacheLoader = new CacheLoader<String, TradeAccount>() {
    @Override
    public TradeAccount load(String key) throws Exception {
      // 实际获取TradeAccount，这里mock实现
      return new TradeAccount(key, "owner", 0.0d);
    }
  };

  @Test
  public void setAndGet() throws ExecutionException {

    LoadingCache<String, TradeAccount> cache =
        CacheBuilder.newBuilder().recordStats().build(cacheLoader);

    cache.put("1", new TradeAccount("1", "owner", 0.0d));

    TradeAccount tradeAccount = cache.get("1");
    Assert.assertNotNull(tradeAccount);

    cache.refresh("1");

    // 不要获取的太早！！！
    CacheStats cacheStats = cache.stats();

    System.out.println(cacheStats.hitCount());
    System.out.println(cacheStats.loadSuccessCount());
    // 其他的统计信息

  }
}
