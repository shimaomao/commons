package com.spike.commons.guice.example.learning.foundation;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.spike.commons.guice.example.learning.support.FlightUtils;

public class Main {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new ApplicationModule());

    // 演示注入
    Client client = injector.getInstance(Client.class);
    client.makeRequest();

    // 演示静态注入
    System.out.println(FlightUtils.getDateFormat());
  }
}
