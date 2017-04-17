package com.spike.commons.guice.example.learning.scoping;

import java.util.Date;

import com.google.inject.Provider;

/**
 * 在一段时间后(60s)创建新实例
 * @author zhoujiagen
 */
public class CSVFlightSupplierProvider implements Provider<CSVFlightSupplier> {

  public static final long DURATION_IN_MS = 5 * 1000;

  private CSVFlightSupplier instance;
  private long timestamp;

  @Override
  public CSVFlightSupplier get() {
    if (instance == null || !inScope()) {
      newInstance();
    }
    return instance;
  }

  private void newInstance() {
    instance = new CSVFlightSupplier();
    timestamp = new Date().getTime();
  }

  private boolean inScope() {
    return (System.currentTimeMillis() - timestamp) > DURATION_IN_MS ? false : true;
  }
}
