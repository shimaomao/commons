package com.spike.commons.guice.example.learning.assisted;

import java.util.Date;

import javax.inject.Inject;

public class Client {

  @Inject
  private SearchRequestFactory searchRequestFactory;

  public void makeRequest() {
    SearchRequest sr = searchRequestFactory.create("AMS", "MAD", new Date());
    System.out.println(sr);
  }
}
