package com.spike.commons.guice.example.learning.assisted;

import java.util.Date;

import com.google.inject.assistedinject.Assisted;

public interface SearchRequestFactory {
  SearchRequest create(//
      @Assisted(SearchRequest.NAME_DEPARTURELOCATION) String departureLocation, //
      @Assisted(SearchRequest.NAME_ARRIVALLOCATION) String arrivalLocation, //
      Date flightDate//
      );
}
