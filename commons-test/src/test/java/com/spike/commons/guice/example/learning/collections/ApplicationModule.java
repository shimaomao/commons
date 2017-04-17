package com.spike.commons.guice.example.learning.collections;

import java.util.List;
import java.util.Set;

import javax.inject.Singleton;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;

public class ApplicationModule extends AbstractModule {

  @Override
  protected void configure() {
    // 1 TypeLiteral
    // (1) 使用Provider
    bind(new TypeLiteral<List<Double>>() {
    })//
    .toProvider(DoubleProvider.class)//
        .in(Singleton.class);
    // (2) 使用@Provides

    // 2 MultiBinder
    Multibinder<FlightSupplier> mb = Multibinder.newSetBinder(binder(), FlightSupplier.class);
    mb.addBinding().to(CSVFlightSupplier.class).asEagerSingleton();
    mb.addBinding().toInstance(new ExcelFlightSupplier());
    mb.addBinding().to(JsonFlightSupplier.class);
  }

  // 必须使用static
  public static class DoubleProvider implements Provider<List<Double>> {
    @Override
    public List<Double> get() {
      List<Double> result = Lists.newArrayList();
      result.add(0d);
      result.add(1d);
      return result;
    }

  }

  @Provides
  public Set<String> provideStringSet() {
    Set<String> result = Sets.newHashSet();
    result.add("Hi Client");
    result.add("Bye Client");
    return result;
  }
}
