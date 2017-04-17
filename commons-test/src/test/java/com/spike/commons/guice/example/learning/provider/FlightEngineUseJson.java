package com.spike.commons.guice.example.learning.provider;

import javax.inject.Inject;
import javax.inject.Named;

public class FlightEngineUseJson {

  // 不需要注入Provider, 只需要注入常规的类
  @Inject
  @Named(FlightSupplier.NAMED_JSON)
  private FlightSupplier flightSupplier;

  // ======================================== constructor
  // no-arguments constructor
  public FlightEngineUseJson() {
  }

  // ======================================== getter/setter
  public FlightSupplier getFlightSupplier() {
    return flightSupplier;
  }

  public void setFlightSupplier(FlightSupplier flightSupplier) {
    this.flightSupplier = flightSupplier;
  }

  @Override
  public String toString() {
    return "FlightEngineUseJson [flightSupplier=" + flightSupplier + "]";
  }

}
