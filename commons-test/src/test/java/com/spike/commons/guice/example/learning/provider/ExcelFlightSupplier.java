package com.spike.commons.guice.example.learning.provider;

public class ExcelFlightSupplier implements FlightSupplier {
  private String excelPath;

  public static class NoExcelAvailableException extends Exception {
    private static final long serialVersionUID = 1L;
  }

  // ======================================== constructor

  public ExcelFlightSupplier() throws NoExcelAvailableException {
    throw new NoExcelAvailableException();
  }

  public ExcelFlightSupplier(String excelPath) {
    this.excelPath = excelPath;
  }

  // ======================================== getter/setter
  public String getExcelPath() {
    return excelPath;
  }

  public void setExcelPath(String excelPath) {
    this.excelPath = excelPath;
  }

  @Override
  public String toString() {
    return "ExcelFlightSupplier [excelPath=" + excelPath + "]";
  }

}
