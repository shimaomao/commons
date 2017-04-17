package com.spike.commons.guice.example.learning.provider;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new ApplicationModule());

    // (1) 实现Provider
    FlightEngine flightEngine = injector.getInstance(FlightEngine.class);
    System.out.println(flightEngine);

    // (2) 在Module定义中使用@Provides的方法
    FlightEngineUseJson flightEngineUseJson = injector.getInstance(FlightEngineUseJson.class);
    System.out.println(flightEngineUseJson);

    // (3) 使用扩展CheckedProvider
    FlightEngineUseExcel flightEngineUseExcel = injector.getInstance(FlightEngineUseExcel.class);
    System.out.println(flightEngineUseExcel);
  }
}
