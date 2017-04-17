package com.spike.commons.guice.example.learning.provider;

import javax.inject.Named;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import com.google.inject.throwingproviders.ThrowingProviderBinder;
import com.spike.commons.guice.example.learning.support.annotation.CSV;

public class ApplicationModule extends AbstractModule {

  @Override
  protected void configure() {

    bind(String.class)//
        .annotatedWith(Names.named("csvPath"))//
        .toInstance("./flightCSV/");

    // (1) 显式绑定
    bind(FlightSupplier.class)//
        .annotatedWith(CSV.class)// FlightEngine中使用@CSV
        .toProvider(CSVFlightSupplierProvider.class);
    // (2) 使用@ProvidedBy, 见FlightSupplier

    // (3) 使用CheckedProvider, 使用依赖guice-throwingproviders
    // FlightSupplierCheckedProvider<T>接口继承CheckedProvider<T>
    // T为FlightSupplier
    // ExcelFlightSupplierCheckedProvider为FlightSupplierCheckedProvider的实现
    ThrowingProviderBinder.create(binder())//
        .bind(FlightSupplierCheckedProvider.class, FlightSupplier.class)//
        .to(ExcelFlightSupplierCheckedProvider.class);
    // (4) 与@Provides类似, 也可以使用@CheckedProvides
  }

  /**
   * 指定{@link Provider}的便捷方式
   * @return
   */
  @Provides
  @Named(FlightSupplier.NAMED_JSON)
  public FlightSupplier provideJsonFlightSupplier() {
    return new JsonFlightSupplier("./flightJSON/");
  }

}
