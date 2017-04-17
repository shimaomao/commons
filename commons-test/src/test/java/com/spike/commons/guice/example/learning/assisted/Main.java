package com.spike.commons.guice.example.learning.assisted;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new ApplicationModule());
    Client client = injector.getInstance(Client.class);
    client.makeRequest();
  }
}
