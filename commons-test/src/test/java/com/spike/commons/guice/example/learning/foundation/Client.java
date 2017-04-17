package com.spike.commons.guice.example.learning.foundation;

import javax.inject.Inject;

public class Client {
  @Inject
  private FlightEngine flightEngine;

  // ======================================== constructor
  // no-arguments constructor
  public Client() {
  }

  public Client(FlightEngine flightEngine) {
    this.flightEngine = flightEngine;
  }

  // ======================================== methods
  public void makeRequest() {
    System.out.println(this.toString());
  }

  // ======================================== getter/setter
  public FlightEngine getFlightEngine() {
    return flightEngine;
  }

  public void setFlightEngine(FlightEngine flightEngine) {
    this.flightEngine = flightEngine;
  }

  @Override
  public String toString() {
    return "Client [flightEngine=" + flightEngine + "]";
  }

}
