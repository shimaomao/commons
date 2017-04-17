package com.spike.commons.guice.example.learning.provider;

import com.google.inject.throwingproviders.CheckedProvider;
import com.spike.commons.guice.example.learning.provider.ExcelFlightSupplier.NoExcelAvailableException;

public interface FlightSupplierCheckedProvider<T> extends CheckedProvider<T> {
  @Override
  T get() throws NoExcelAvailableException;
}
