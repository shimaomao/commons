package com.spike.commons.guice.example.learning.foundation;

import javax.inject.Inject;
import javax.inject.Named;

import com.spike.commons.guice.example.learning.support.annotation.XML;

public class FlightEngine {

  public static final String NAMED_MAXRESULTS = "maxResults";

  @Inject
  // 使用@Named
  // @Named("CSVFileFlightSupplier")
  // 使用自定义绑定注解
  @XML
  private FlightSupplier flightSupplier;

  @Inject
  @Named(NAMED_MAXRESULTS)
  private int maxResults;

  // ======================================== constructor
  // no-arguments constructor
  public FlightEngine() {
  }

  public FlightEngine(FlightSupplier flightSupplier) {
    this.flightSupplier = flightSupplier;
  }

  // ======================================== getter/setter
  public FlightSupplier getFlightSupplier() {
    return flightSupplier;
  }

  public void setFlightSupplier(FlightSupplier flightSupplier) {
    this.flightSupplier = flightSupplier;
  }

  public int getMaxResults() {
    return maxResults;
  }

  public void setMaxResults(int maxResults) {
    this.maxResults = maxResults;
  }

  @Override
  public String toString() {
    return "FlightEngine [flightSupplier=" + flightSupplier + ", maxResults=" + maxResults + "]";
  }

}
