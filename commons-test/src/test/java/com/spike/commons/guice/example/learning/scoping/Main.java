package com.spike.commons.guice.example.learning.scoping;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    Injector injector = Guice.createInjector(new ApplicationModule());

    // 1 singleton with same id
    FlightEngine flightEngine = injector.getInstance(FlightEngine.class);
    System.out.println(flightEngine);
    FlightEngine flightEngine2 = injector.getInstance(FlightEngine.class);
    System.out.println(flightEngine2);

    // 2 scope
    ClientWithScope client = injector.getInstance(ClientWithScope.class);
    System.out.println(client);

    Thread.sleep(CSVFlightSupplierProvider.DURATION_IN_MS + 1000);

    ClientWithScope client2 = injector.getInstance(ClientWithScope.class);
    System.out.println(client2);

    // should be false
    System.out.println(client.getFlightSupplier().getId()
        .equals(client2.getFlightSupplier().getId()));
  }
}
