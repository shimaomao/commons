package com.spike.commons.guice.example.learning.foundation;

import java.util.Set;

// 直接指定接口的实现类
// @ImplementedBy(XMLFlightSupplier.class)
public interface FlightSupplier {
  // 实现类的名称
  String CSVFlightSupplier = "CSVFlightSupplier";
  String CSVFolderFlightSupplier = "CSVFolderFlightSupplier";
  String XMLFlightSupplier = "XMLFlightSupplier";

  // @Named绑定的名称
  String NAMED_CSVPATH = "csvPath";
  String NAMED_XMLPATH = "xmlPath";
  // 属性文件中键
  String PROPERTIES_NAMED_CSVPATH = "com.spike.commons.guice.learning.csvPath";
  String PROPERTIES_NAMED_XMLPATH = "com.spike.commons.guice.learning.xmlPath";

  Set<SearchResponse> getResults();
}
