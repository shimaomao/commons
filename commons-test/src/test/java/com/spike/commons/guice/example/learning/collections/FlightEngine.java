package com.spike.commons.guice.example.learning.collections;

import java.util.Set;

import javax.inject.Inject;

public class FlightEngine {

  // 只能是Set集合
  @Inject
  private Set<FlightSupplier> flightSuppliers;

  // ======================================== getter/setter

  public Set<FlightSupplier> getFlightSuppliers() {
    return flightSuppliers;
  }

  public void setFlightSuppliers(Set<FlightSupplier> flightSuppliers) {
    this.flightSuppliers = flightSuppliers;
  }

  @Override
  public String toString() {
    return "FlightEngine [flightSuppliers=" + flightSuppliers + "]";
  }
}
