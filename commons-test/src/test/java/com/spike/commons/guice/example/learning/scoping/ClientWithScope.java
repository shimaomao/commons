package com.spike.commons.guice.example.learning.scoping;

import javax.inject.Inject;

import com.spike.commons.guice.example.learning.support.annotation.CSV;

public class ClientWithScope {

  @Inject
  @CSV
  private FlightSupplier flightSupplier;

  // ======================================== getter/setter
  public FlightSupplier getFlightSupplier() {
    return flightSupplier;
  }

  public void setFlightSupplier(FlightSupplier flightSupplier) {
    this.flightSupplier = flightSupplier;
  }

  @Override
  public String toString() {
    return "ClientWithScope [flightSupplier=" + flightSupplier + "]";
  }

}
