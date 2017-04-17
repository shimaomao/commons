package com.spike.commons.guice.example.learning.foundation;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

public class XMLFlightSupplier implements FlightSupplier {

  @Inject
  // 使用属性文件中键
  @Named(PROPERTIES_NAMED_XMLPATH)
  private String xmlPath;

  // ======================================== constructor
  // no-arguments constructor
  public XMLFlightSupplier() {
  }

  // ======================================== methods
  @Override
  public Set<SearchResponse> getResults() {
    // TODO Implement XMLFlightSupplier.getResults
    return null;
  }

  // ======================================== getter/setter
  public String getXmlPath() {
    return xmlPath;
  }

  public void setXmlPath(String xmlPath) {
    this.xmlPath = xmlPath;
  }

  @Override
  public String toString() {
    return "XMLFlightSupplier [xmlPath=" + xmlPath + "]";
  }

}
