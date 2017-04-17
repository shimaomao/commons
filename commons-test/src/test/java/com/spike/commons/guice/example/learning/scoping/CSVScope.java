package com.spike.commons.guice.example.learning.scoping;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;

public class CSVScope implements Scope {

  @SuppressWarnings("unchecked")
  @Override
  public <T> Provider<T> scope(Key<T> key, Provider<T> unscoped) {
    return (Provider<T>) new CSVFlightSupplierProvider();
  }

}
