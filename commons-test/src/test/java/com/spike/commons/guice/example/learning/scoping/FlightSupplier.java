package com.spike.commons.guice.example.learning.scoping;

import com.spike.commons.lang.RandomUtils;
import com.spike.commons.lang.RandomUtils.IdPattern;

public interface FlightSupplier {
  String getId();

  class DefaultFlightSupplier implements FlightSupplier {
    protected String id = RandomUtils.nextId(IdPattern.UpperCase);

    public String getId() {
      return id;
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + " [id=" + id + "]";
    }

  }
}
