package com.spike.commons.guice.example.learning.collections;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

public class Client {

  @Inject
  private List<Double> values;

  @Inject
  private Set<String> message;

  // ======================================== getter/setter
  public List<Double> getValues() {
    return values;
  }

  public void setValues(List<Double> values) {
    this.values = values;
  }

  public Set<String> getMessage() {
    return message;
  }

  public void setMessage(Set<String> message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "Client [values=" + values + ", message=" + message + "]";
  }

}
