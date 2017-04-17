package com.spike.commons.guice.example.learning.provider;

import javax.inject.Inject;

import com.spike.commons.guice.example.learning.provider.ExcelFlightSupplier.NoExcelAvailableException;

public class FlightEngineUseExcel {

  // 注入CheckedProvider
  @Inject
  private FlightSupplierCheckedProvider<FlightSupplier> flightSupplierCheckedProvider;

  // ======================================== constructor
  // no-arguments constructor
  public FlightEngineUseExcel() {
  }

  // ======================================== getter/setter

  public FlightSupplierCheckedProvider<FlightSupplier> getFlightSupplierCheckedProvider() {
    return flightSupplierCheckedProvider;
  }

  public void setFlightSupplierCheckedProvider(
      FlightSupplierCheckedProvider<FlightSupplier> flightSupplierCheckedProvider) {
    this.flightSupplierCheckedProvider = flightSupplierCheckedProvider;
  }

  @Override
  public String toString() {
    try {
      return "FlightEngineUseExcel [flightSupplierCheckedProvider.get()="
          + flightSupplierCheckedProvider.get() + "]";
    } catch (NoExcelAvailableException e) {
      e.printStackTrace();
      return "FlightEngineUseExcel [e=" + e.getMessage() + "]";
    }
  }

}
