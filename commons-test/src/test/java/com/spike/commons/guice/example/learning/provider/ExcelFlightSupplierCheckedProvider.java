package com.spike.commons.guice.example.learning.provider;

import com.spike.commons.guice.example.learning.provider.ExcelFlightSupplier.NoExcelAvailableException;

public class ExcelFlightSupplierCheckedProvider implements
    FlightSupplierCheckedProvider<FlightSupplier> {

  @Override
  public ExcelFlightSupplier get() {
    try {
      return new ExcelFlightSupplier();
    } catch (NoExcelAvailableException e) {
      System.err.println("FAILED WHEN CALL new ExcelFlightSupplier()");
      e.printStackTrace();
      return new ExcelFlightSupplier("./excelPath");
    }
  }
}
