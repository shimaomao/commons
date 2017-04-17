package com.spike.commons.guice.example.learning.provider;

public class JsonFlightSupplier implements FlightSupplier {

  private String jsonPath;

  // ======================================== constructor
  // no-arguments constructor
  public JsonFlightSupplier() {
  }

  public JsonFlightSupplier(String jsonPath) {
    this.jsonPath = jsonPath;
  }

  // ======================================== getter/setter
  public String getJsonPath() {
    return jsonPath;
  }

  public void setJsonPath(String jsonPath) {
    this.jsonPath = jsonPath;
  }

  @Override
  public String toString() {
    return "JsonFlightSupplier [jsonPath=" + jsonPath + "]";
  }

}
