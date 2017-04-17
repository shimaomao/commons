package com.spike.commons.guice.example.learning.scoping;

import javax.inject.Singleton;

import com.spike.commons.guice.example.learning.scoping.FlightSupplier.DefaultFlightSupplier;

@Singleton
public class JsonFlightSupplier extends DefaultFlightSupplier {
}
