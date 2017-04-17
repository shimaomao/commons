package com.spike.commons.guice.example.learning.scoping;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;
import com.spike.commons.guice.example.learning.support.annotation.CSV;

public class ApplicationModule extends AbstractModule {

  @Override
  protected void configure() {
    Multibinder<FlightSupplier> mb = Multibinder.newSetBinder(binder(), FlightSupplier.class);
    mb.addBinding().to(CSVFlightSupplier.class).in(Scopes.SINGLETON);
    mb.addBinding().to(ExcelFlightSupplier.class).in(Singleton.class);
    mb.addBinding().to(JsonFlightSupplier.class);
    mb.addBinding().to(TxtFlightSupplier.class).asEagerSingleton(); // 非lazy initialization

    // 自定义scope
    bind(FlightSupplier.class)//
        .annotatedWith(CSV.class)//
        .toProvider(CSVFlightSupplierProvider.class)//
        .in(new CSVScope());
  }

}
