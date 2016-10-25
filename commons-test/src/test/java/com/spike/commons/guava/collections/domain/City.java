package com.spike.commons.guava.collections.domain;

public class City {
  private Climate climate;
  private long population;
  private double averageRainfall;

  public City(Climate climate, long population, double averageRainfall) {
    this.climate = climate;
    this.population = population;
    this.averageRainfall = averageRainfall;
  }

  public Climate getClimate() {
    return climate;
  }

  public void setClimate(Climate climate) {
    this.climate = climate;
  }

  public long getPopulation() {
    return population;
  }

  public void setPopulation(long population) {
    this.population = population;
  }

  public double getAverageRainfall() {
    return averageRainfall;
  }

  public void setAverageRainfall(double averageRainfall) {
    this.averageRainfall = averageRainfall;
  }

  @Override
  public String toString() {
    return "City [climate=" + climate + ", population=" + population + ", averageRainfall="
        + averageRainfall + "]";
  }

}