package com.spike.commons.guice.example.learning.assisted;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class ApplicationModule extends AbstractModule {

  @Override
  protected void configure() {
    FactoryModuleBuilder fmb = new FactoryModuleBuilder();
    install(fmb.build(SearchRequestFactory.class));
  }

}
