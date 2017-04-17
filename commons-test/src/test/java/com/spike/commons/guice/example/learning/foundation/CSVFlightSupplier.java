package com.spike.commons.guice.example.learning.foundation;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

public class CSVFlightSupplier implements FlightSupplier {

  // example: ./flightCSV/
  @Inject
  // 使用自定义名称
  @Named(NAMED_CSVPATH)
  private String csvPath;

  // ======================================== constructor
  // no-arguments constructor
  public CSVFlightSupplier() {
  }

  public CSVFlightSupplier(String csvPath) {
    this.csvPath = csvPath;
  }

  // ======================================== methods
  @Override
  public Set<SearchResponse> getResults() {
    // TODO Implement CSVFlightSupplier.getResults
    return null;
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
