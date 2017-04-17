package com.spike.commons.guice.example.learning.provider;

public class CSVFlightSupplier implements FlightSupplier {

  private String csvPath;

  // ======================================== constructor
  // no-arguments constructor
  public CSVFlightSupplier() {
  }

  public CSVFlightSupplier(String csvPath) {
    this.csvPath = csvPath;
  }

  // ======================================== getter/setter
  public String getCsvPath() {
    return csvPath;
  }

  public void setCsvPath(String csvPath) {
    this.csvPath = csvPath;
  }

  @Override
  public String toString() {
    return "CSVFlightSupplier [csvPath=" + csvPath + "]";
  }

}
