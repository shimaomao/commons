package com.spike.commons.guice.example.learning.provider;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.spike.commons.guice.example.learning.support.annotation.CSV;

public class FlightEngine {

  // 注入Provider
  @Inject
  @CSV
  private Provider<FlightSupplier> csvFlightSupplier;

  // ======================================== constructor
  // no-arguments constructor
  public FlightEngine() {
  }

  // ======================================== getter/setter
  public Provider<FlightSupplier> getCsvFlightSupplier() {
    return csvFlightSupplier;
  }

  public void setCsvFlightSupplier(Provider<FlightSupplier> csvFlightSupplier) {
    this.csvFlightSupplier = csvFlightSupplier;
  }

  @Override
  public String toString() {
    return "FlightEngine [csvFlightSupplier.get()=" + csvFlightSupplier.get() + "]";
  }

}
