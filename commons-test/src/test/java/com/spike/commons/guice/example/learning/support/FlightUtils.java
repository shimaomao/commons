package com.spike.commons.guice.example.learning.support;

import javax.inject.Inject;
import javax.inject.Named;

public class FlightUtils {
  public static final String NAMED_DATE_FORMAT = "df";

  @Inject
  @Named(NAMED_DATE_FORMAT)
  private static String dateFormat;

  public static String getDateFormat() {
    return dateFormat;
  }

  public static void setDateFormat(String dateFormat) {
    FlightUtils.dateFormat = dateFormat;
  }

}
