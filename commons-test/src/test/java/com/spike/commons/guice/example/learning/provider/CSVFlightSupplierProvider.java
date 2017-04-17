package com.spike.commons.guice.example.learning.provider;

import javax.inject.Inject;
import javax.inject.Named;

import com.google.inject.Provider;

/**
 * {@link CSVFlightSupplier}的{@link Provider}
 * @author zhoujiagen
 */
public class CSVFlightSupplierProvider implements Provider<CSVFlightSupplier> {

  @Inject
  @Named("csvPath")
  private String csvPath; // 例: ./flightCSV/

  @Override
  public CSVFlightSupplier get() {
    CSVFlightSupplier result = new CSVFlightSupplier(csvPath);
    return result;
  }

}
