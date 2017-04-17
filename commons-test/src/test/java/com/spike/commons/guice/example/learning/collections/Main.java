package com.spike.commons.guice.example.learning.collections;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new ApplicationModule());

    // (1) TypeLiteral绑定原始类型集合
    Client client = injector.getInstance(Client.class);
    System.out.println(client);

    // (2) MultiBinder绑定自定义类集合
    FlightEngine flightEngine = injector.getInstance(FlightEngine.class);
    System.out.println(flightEngine);
  }
}
