package com.spike.commons.guice.example.learning.foundation;

import java.io.File;
import java.util.Set;

import javax.inject.Inject;

import com.google.common.collect.Sets;

public class CSVFolderFlightSupplier implements FlightSupplier {

  @Inject
  // 使用构造器注入
  private File csvFolder;

  // ======================================== constructor
  // no-arguments constructor
  public CSVFolderFlightSupplier() {
  }

  // ======================================== methods
  @Override
  public Set<SearchResponse> getResults() {
    return Sets.newHashSet();
  }

  // ======================================== getter/setter
  public File getCsvFolder() {
    return csvFolder;
  }

  public void setCsvFolder(File csvFolder) {
    this.csvFolder = csvFolder;
  }

  @Override
  public String toString() {
    return "CSVFolderFlightSupplier [csvFolder=" + csvFolder.getAbsolutePath() + "]";
  }

}
