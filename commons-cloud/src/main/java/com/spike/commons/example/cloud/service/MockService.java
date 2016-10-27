package com.spike.commons.example.cloud.service;

import org.springframework.stereotype.Service;

@Service
public class MockService {
  public String mock() {
    return this.getClass().getCanonicalName();
  }
}
