package com.spike.commons.guice.example.learning.assisted;

import java.util.Date;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

public class SearchRequest {
  // 辅助参数命名
  public static final String NAME_DEPARTURELOCATION = "departureLocation";
  public static final String NAME_ARRIVALLOCATION = "arrivalLocation";

  private String departureLocation;
  private String arrivalLocation;
  private Date flightDate;

  // ======================================== constructor
  @AssistedInject
  public SearchRequest(//
      @Assisted(NAME_DEPARTURELOCATION) String departureLocation, //
      @Assisted(NAME_ARRIVALLOCATION) String arrivalLocation, //
      @Assisted Date flightDate//
  ) {
    this.departureLocation = departureLocation;
    this.arrivalLocation = arrivalLocation;
    this.flightDate = flightDate;
  }

  // ======================================== getter/setter
  public String getDepartureLocation() {
    return departureLocation;
  }

  public String getArrivalLocation() {
    return arrivalLocation;
  }

  public Date getFlightDate() {
    return flightDate;
  }

  @Override
  public String toString() {
    return "SearchRequest [departureLocation=" + departureLocation + ", arrivalLocation="
        + arrivalLocation + ", flightDate=" + flightDate + "]";
  }

}
