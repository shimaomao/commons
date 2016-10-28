package com.spike.commons.example.cloud.netflix.service;

import org.springframework.stereotype.Service;

@Service("mock")
public class MockService {
  public String mock(String param) {
    if (param == null || "".equals(param.trim())) {
      return "NULL";
    } else {
      return param.toUpperCase();
    }
  }
}
